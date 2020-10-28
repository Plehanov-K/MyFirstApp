package com.pliakhanau.myfirstapplication.homeWorkMothersDay

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.pliakhanau.myfirstapplication.R
import kotlinx.android.synthetic.main.activity_mothers_day.*
import kotlinx.coroutines.*

class MothersDayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mothers_day)

        val job = getJob()

        buttonHeart.setOnClickListener {
            job.cancel()
            startActivity(Intent(this, GreetingActivity::class.java))
            overridePendingTransition(R.anim.start_show,R.anim.end_show)
        }
    }

    override fun onResume() {
        super.onResume()
        getJob()
    }

    fun getJob(): Job {
        return CoroutineScope(Dispatchers.Main).launch {
            bounceFrame()
            while (isActive) {
                pulseButton()
                fadeHeart()
            }
        }
    }

    private fun bounceFrame() {
        YoYo.with(Techniques.BounceIn)
            .duration(3000)
            .playOn(imageViewFrameHeart)
    }

    private  fun pulseButton() {
        YoYo.with(Techniques.Pulse)
            .duration(2000)
            .playOn(buttonHeart)
    }

    private suspend fun fadeHeart() {
        YoYo.with(Techniques.FadeOut)
            .duration(1000)
            .playOn(littleHeartLeft)

        YoYo.with(Techniques.FadeInUp)
            .duration(2000)
            .playOn(littleHeartRight)

        delay(1000)

        YoYo.with(Techniques.FadeInUp)
            .duration(2000)
            .playOn(littleHeartLeft)

        delay(1000)

        YoYo.with(Techniques.FadeOut)
            .duration(1000)
            .playOn(littleHeartRight)

        delay(1000)
    }
}
