package com.example.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class signUp2 : AppCompatActivity() {

    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up2)

        nextButton = findViewById(R.id.button1)

        nextButton.setOnClickListener{
            val intent: Intent = Intent(this, Services::class.java)

            startActivity(intent)
        }

    }
}