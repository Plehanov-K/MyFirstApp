package com.pliakhanau.myfirstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pliakhanau.myfirstapplication.homeWork1.PicassoActivity
import com.pliakhanau.myfirstapplication.homeWork2.AnimationFlagsActivity
import com.pliakhanau.myfirstapplication.homeWork3.VegetablesActivity
import com.pliakhanau.myfirstapplication.homeWork4.CoffeeActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonPicasso.setOnClickListener {
            startActivity(Intent(this, PicassoActivity::class.java))
        }

        buttonFlagsAnimation.setOnClickListener {
            startActivity(Intent(this, AnimationFlagsActivity::class.java))
        }

        buttonVegetables.setOnClickListener {
            startActivity(Intent(this, VegetablesActivity::class.java))
        }

        buttonCoffee.setOnClickListener {
            startActivity(Intent(this, CoffeeActivity::class.java))
        }

    }
}