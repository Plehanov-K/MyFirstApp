package com.pliakhanau.myfirstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_animation_flags.*

class AnimationFlagsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_flags)

        buttonFlags.setOnClickListener {
            startActivity(Intent(this,FlagsActivity::class.java))
        }

        buttonAnimation.setOnClickListener {
            startActivity(Intent(this,AnimationActivity::class.java))
        }
    }
}