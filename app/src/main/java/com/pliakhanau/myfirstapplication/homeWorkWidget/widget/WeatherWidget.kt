package com.pliakhanau.myfirstapplication.homeWorkWidget.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.RemoteViews
import android.widget.Toast
import com.pliakhanau.myfirstapplication.R
import com.pliakhanau.myfirstapplication.homeWorkWidget.WeatherActivity
import com.pliakhanau.myfirstapplication.homeWorkWidget.dto.WeatherResponse
import com.pliakhanau.myfirstapplication.homeWorkWidget.mapper.WeatherMapper
import com.pliakhanau.myfirstapplication.homeWorkWidget.retrofit.WeatherRetrofitFactory
import com.squareup.picasso.Picasso
import kotlinx.coroutines.*
import retrofit2.Response

/**
 * Implementation of App Widget functionality.
 * App Widget Configuration implemented in [WeatherWidgetConfigureActivity]
 */

private const val WIDGETID = "mWidgetId"

class WeatherWidget : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onDeleted(context: Context, appWidgetIds: IntArray) {
        // When the user deletes the widget, delete the preference associated with it.
        for (appWidgetId in appWidgetIds) {
            deleteTitlePref(context, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        super.onReceive(context, intent)
        val appWidgetManager = AppWidgetManager.getInstance(context)
        val appWidgetId = intent?.getIntExtra(WIDGETID,AppWidgetManager.INVALID_APPWIDGET_ID)
        if(appWidgetId != AppWidgetManager.INVALID_APPWIDGET_ID ){
            context?.let { appWidgetId?.let { it1 -> updateAppWidget(it,appWidgetManager, it1) } }
        }
    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {

    val actionUpdateIntent = Intent()
    actionUpdateIntent.action = AppWidgetManager.ACTION_APPWIDGET_UPDATE
    actionUpdateIntent.putExtra(WIDGETID,appWidgetId)

    val updateIntent = PendingIntent.getBroadcast(
        context,
        0,
        actionUpdateIntent,
        PendingIntent.FLAG_UPDATE_CURRENT
    )
    val views = RemoteViews(context.packageName, R.layout.weather_widget)

    views.setOnClickPendingIntent(R.id.update_widget, updateIntent)

    val widgetText = loadTitlePref(context, appWidgetId)

    // Construct the RemoteViews object
    views.setTextViewText(R.id.appwidget_text, widgetText)

    appWidgetManager.updateAppWidget(appWidgetId, views)

    if(widgetText.isNotEmpty()) {
        CoroutineScope(Dispatchers.IO).launch {
            var result: Response<WeatherResponse>? = null
            try {
                result = WeatherRetrofitFactory.provideApi().getWeather(widgetText).await()
            } catch (e: Throwable) {
                Log.e("Errr", e.toString())
            }
            if (result != null) {
                if (result.isSuccessful) {
                    val rateResponse: WeatherResponse? = result.body()
                    var rate = rateResponse?.let { WeatherMapper().map(it) }
                    views.setTextViewText(R.id.appwidget_text, rate?.name)
                    views.setTextViewText(R.id.widget_temp, rate?.temp.toString().plus("\u2103"))
                    views.setTextViewText(R.id.widget_weather_description_text, rate?.description)
                    views.setImageViewBitmap(
                        R.id.weather_icon,
                        Picasso.get().load("https://openweathermap.org/img/wn/10d@2x.png").get()
                    )
                    appWidgetManager.updateAppWidget(appWidgetId, views)
                }
            }
        }
    }
}