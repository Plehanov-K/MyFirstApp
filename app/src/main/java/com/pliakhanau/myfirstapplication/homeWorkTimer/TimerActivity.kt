package com.pliakhanau.myfirstapplication.homeWorkTimer

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.annotation.RequiresApi
import com.pliakhanau.myfirstapplication.R
import kotlinx.android.synthetic.main.activity_timer.*

const val KEY = "key"

class TimerActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)

        val intent = Intent(this, MyForegroundService::class.java)
        time_picker.setIs24HourView(true)

        btnGetTime.setOnClickListener {
                val time = (time_picker.hour * 60 + time_picker.minute)
                intent.putExtra(KEY, (time * 60000L))
                startService(intent)
        }
    }
}
