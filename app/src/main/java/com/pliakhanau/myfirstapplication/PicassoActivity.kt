package com.pliakhanau.myfirstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_picasso.*
import com.squareup.picasso.Picasso

class PicassoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picasso)

        buttonLoad.setOnClickListener {

            val url = editText.text.toString().trim()

            if (!url.isBlank())
                Picasso.get()
                    .load(url)
                    .error(R.drawable.error)
                    .into(imageView)
        }
    }
}