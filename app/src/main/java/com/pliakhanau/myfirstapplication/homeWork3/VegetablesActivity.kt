package com.pliakhanau.myfirstapplication.homeWork3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pliakhanau.myfirstapplication.R
import kotlinx.android.synthetic.main.activity_vegetables.*

class VegetablesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vegetables)

        val viewModel: MyViewModel = ViewModelProvider(this).get(MyViewModel::class.java)


        Region.Minsk.apply {
            potato.observe(this@VegetablesActivity, Observer { number ->
                counterMinskPotato.text = number.toString()
                loadingMinskPotato.layoutParams.width = number * 3
            })
            beet.observe(this@VegetablesActivity, Observer { number ->
                counterMinskBeet.text = number.toString()
                loadingMinskBeet.layoutParams.width = number * 3
            })
            cabbage.observe(this@VegetablesActivity, Observer { number ->
                counterMinskCabbage.text = number.toString()
                loadingMinskCabbage.layoutParams.width = number * 3
            })
        }

        Region.Gomel.apply {
            potato.observe(this@VegetablesActivity, Observer { number ->
                counterGomelPotato.text = number.toString()
                loadingGomelPotato.layoutParams.width = number * 3
            })
            beet.observe(this@VegetablesActivity, Observer { number ->
                counterGomelBeet.text = number.toString()
                loadingGomelBeet.layoutParams.width = number * 3
            })
            cabbage.observe(this@VegetablesActivity, Observer { number ->
                counterGomelCabbage.text = number.toString()
                loadingGomelCabbage.layoutParams.width = number * 3
            })
        }

        Region.Brest.apply {
            potato.observe(this@VegetablesActivity, Observer { number ->
                counterBrestPotato.text = number.toString()
                loadingBrestPotato.layoutParams.width = number * 3
            })
            beet.observe(this@VegetablesActivity, Observer { number ->
                counterBrestBeet.text = number.toString()
                loadingBrestBeet.layoutParams.width = number * 3
            })
            cabbage.observe(this@VegetablesActivity, Observer { number ->
                counterBrestCabbage.text = number.toString()
                loadingBrestCabbage.layoutParams.width = number * 3
            })
        }

        viewModel.play()

        viewModel.winner.observe(this, Observer { winner ->
            Toast.makeText(
                this,
                "Победил $winner",
                Toast.LENGTH_LONG
            ).show()
        })


    }
}