package com.pliakhanau.myfirstapplication.homeWorkMothersDay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pliakhanau.myfirstapplication.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_greeting.*

class GreetingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_greeting)

        Picasso.get().load(R.drawable.mamagif).error(R.drawable.error).into(gifCelebration)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.start_show, R.anim.end_show)
    }
}