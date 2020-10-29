package com.pliakhanau.myfirstapplication.homeWorkBackendless

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pliakhanau.myfirstapplication.R

class BackendlessActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_backendless)
        setSupportActionBar(findViewById(R.id.toolbar))
    }
}