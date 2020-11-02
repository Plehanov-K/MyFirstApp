package com.pliakhanau.myfirstapplication.homeWorkTimer

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.CountDownTimer
import android.os.IBinder
import androidx.annotation.RequiresApi
import com.pliakhanau.myfirstapplication.R

class MyForegroundService : Service() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate() {
        super.onCreate()
    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val time = intent?.getLongExtra(KEY, 0)

        val intent2 = Intent(this, TimerActivity::class.java)

        val pendingIntent =
            PendingIntent.getActivity(this, 1, intent2, PendingIntent.FLAG_CANCEL_CURRENT)

        val manager = getSystemService(NotificationManager::class.java)

        val mNotification = Notification.Builder(this, NOTIFICATION_CHANNEL_ID)
        mNotification.setContentTitle("Секундомер")
            .setSmallIcon(R.drawable.ic_alarm)
            .setContentIntent(pendingIntent)
        startForeground(1,mNotification.build())

        val timer = object : CountDownTimer(time ?: 0, 1000) {
            override fun onFinish() {
                mNotification.setContentText("Время вышло")
                manager.notify(1, mNotification.build())
            }

            override fun onTick(millisUntilFinished: Long) {
                mNotification.setContentText((millisUntilFinished / 1000).toString())
                manager.notify(1, mNotification.build())
            }
        }.start()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
}