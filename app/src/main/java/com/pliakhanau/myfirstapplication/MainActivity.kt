package com.pliakhanau.myfirstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pliakhanau.myfirstapplication.homeWork1.PicassoActivity
import com.pliakhanau.myfirstapplication.homeWork2.AnimationFlagsActivity
import com.pliakhanau.myfirstapplication.homeWork3.VegetablesActivity
import com.pliakhanau.myfirstapplication.homeWork4.CoffeeActivity
import com.pliakhanau.myfirstapplication.homeWork5.VerificationActivity
import com.pliakhanau.myfirstapplication.homeWorkBackendless.BackendlessActivity
import com.pliakhanau.myfirstapplication.homeWorkMothersDay.MothersDayActivity
import com.pliakhanau.myfirstapplication.homeWorkDataBase.ShopActivity
import com.pliakhanau.myfirstapplication.homeWorkLuxmeter.LuxmeterActivity
import com.pliakhanau.myfirstapplication.homeWorkNetwork.NetworkActivity
import com.pliakhanau.myfirstapplication.homeWorkTimer.TimerActivity
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

        buttonVerification.setOnClickListener {
            startActivity(Intent(this, VerificationActivity::class.java))
        }

        buttonMothersDay.setOnClickListener {
            startActivity(Intent(this, MothersDayActivity::class.java))
        }

        buttonNetwork.setOnClickListener {
            startActivity(Intent(this, NetworkActivity::class.java))
        }

        buttonShop.setOnClickListener {
            startActivity(Intent(this, ShopActivity::class.java))
        }

        buttonNetwork.setOnClickListener {
            startActivity(Intent(this, NetworkActivity::class.java))
        }

        buttonBackendless.setOnClickListener {
            startActivity(Intent(this, BackendlessActivity::class.java))
        }

        buttonTimer.setOnClickListener {
            startActivity(Intent(this, TimerActivity::class.java))
        }

        buttonLuxmeter.setOnClickListener {
            startActivity(Intent(this, LuxmeterActivity::class.java))
        }

        buttonTests.setOnClickListener {
            startActivity(Intent(this, TimerActivity::class.java))
        }

    }
}

