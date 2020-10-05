package com.pliakhanau.myfirstapplication.homeWork5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.pliakhanau.myfirstapplication.R
import kotlinx.android.synthetic.main.activity_verification.*

private const val NAME_KEY = "name key"

class VerificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification)

        editTextName.addTextChangedListener {
            if (it.isNullOrEmpty()) {
                textFieldName.error = "Name must not be empty"
            } else {
                textFieldName.isErrorEnabled = false
            }
        }
        editTextPassword.addTextChangedListener {
            if (editTextPassword.length() < 8) {
                textFieldPassword.error = "Password cannot be less than 8 characters"
            } else {
                textFieldPassword.isErrorEnabled = false
            }
        }

        buttonRegister.setOnClickListener {
            val name = editTextName.text.toString()
            if (name.isNotEmpty() && editTextPassword.length() > 7) {
                MaterialAlertDialogBuilder(this)
                    .setTitle(name)
                    .setMessage(resources.getString(R.string.supporting_text))
                    .setNeutralButton(resources.getString(R.string.buttonOk)) { _, _ ->
                    }
                    .setPositiveButton(resources.getString(R.string.buttonSignIn)) { _, _ ->
                        val intent = Intent(this, WelcomActivity::class.java)
                        intent.putExtra(NAME_KEY, name)
                        startActivity(intent)
                    }
                    .setIcon(R.drawable.login)
                    .show()
            } else Toast.makeText(this, "Some fields filled incorrectly", Toast.LENGTH_SHORT).show()
        }
    }
}