package com.pliakhanau.myfirstapplication.homeWorkWidget

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pliakhanau.myfirstapplication.R
import com.pliakhanau.myfirstapplication.homeWorkWidget.widget.WeatherWidgetConfigureActivity
import kotlinx.android.synthetic.main.weather_widget_configure.*

class WeatherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.weather_widget_configure)


        add_button.setOnClickListener {
            startActivity(Intent(this,WeatherWidgetConfigureActivity::class.java))
        }
    }
}