package com.pliakhanau.myfirstapplication.homeWorkBackendless

import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pliakhanau.myfirstapplication.R
import com.pliakhanau.myfirstapplication.homeWorkBackendless.viewModel.ClientViewModel
import kotlinx.android.synthetic.main.activity_coffee.*

class BackendlessActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_backendless)
        setSupportActionBar(findViewById(R.id.toolbar))
    }
}