package com.pliakhanau.myfirstapplication.homeWork5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pliakhanau.myfirstapplication.R
import kotlinx.android.synthetic.main.activity_welcome.*

private const val NAME_KEY = "name key"

class WelcomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val name = intent.getStringExtra(NAME_KEY)
        textViewWelcome.setText("Welcom $name")
    }
}