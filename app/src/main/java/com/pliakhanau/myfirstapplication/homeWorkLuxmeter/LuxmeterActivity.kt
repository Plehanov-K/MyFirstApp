package com.pliakhanau.myfirstapplication.homeWorkLuxmeter

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pliakhanau.myfirstapplication.R
import kotlinx.android.synthetic.main.activity_luxmeter.*

class LuxmeterActivity : AppCompatActivity(), SensorEventListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_luxmeter)

        val sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        val lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)

        sensorManager.registerListener(this, lightSensor, 1)
    }

    override fun onSensorChanged(p0: SensorEvent?) {
        p0?.values?.get(0)?.let {
            text_meter.text = it.toString().plus(" lux")
            if (it >= 300.0) luxmeter_layout.setBackgroundColor(resources.getColor(R.color.colorButton))
            else luxmeter_layout.setBackgroundColor(resources.getColor(R.color.colorFlagRed))
        }
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }
}