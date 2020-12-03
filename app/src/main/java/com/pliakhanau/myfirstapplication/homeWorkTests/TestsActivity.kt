package com.pliakhanau.myfirstapplication.homeWorkTests

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.text.isDigitsOnly
import androidx.core.widget.addTextChangedListener
import com.pliakhanau.myfirstapplication.R
import kotlinx.android.synthetic.main.activity_tests.*

class TestsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tests)

        var result = text_view_result_fibonacci

        edit_text_fibonacci.addTextChangedListener {

            if (edit_text_fibonacci.text.isNotEmpty()) {
                val number: Int = edit_text_fibonacci.text.toString().toInt()
                result.text = Fibonacci.counter(number).toString()
            } else result.text = ""
        }
    }
}