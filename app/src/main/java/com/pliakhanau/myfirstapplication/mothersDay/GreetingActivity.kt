package com.pliakhanau.myfirstapplication.mothersDay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pliakhanau.myfirstapplication.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_greeting.*
import kotlinx.android.synthetic.main.fragment_coffe_shop.*

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