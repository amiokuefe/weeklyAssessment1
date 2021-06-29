package com.example.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Services : AppCompatActivity() {

    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services)

        nextButton = findViewById(R.id.button6)

        nextButton.setOnClickListener{
            val intent: Intent = Intent(Intent.ACTION_DIAL)
            startActivity(intent)
        }

    }
}