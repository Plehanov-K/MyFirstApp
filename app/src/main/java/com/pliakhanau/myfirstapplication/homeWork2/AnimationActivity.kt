package com.pliakhanau.myfirstapplication.homeWork2

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.pliakhanau.myfirstapplication.R
import kotlinx.android.synthetic.main.activity_animation.*

class AnimationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)

        Glide.with(this).load(R.drawable.disco_ball).into(disco_ball);

        cat.setBackgroundResource(R.drawable.animation_cat)

        val myCat: AnimationDrawable = cat.background as AnimationDrawable

        myCat.start()

        cat.setOnClickListener {
            if (myCat.isRunning) myCat.stop() else myCat.start()
        }
    }
}