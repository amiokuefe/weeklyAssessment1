package com.example.persistenceclone

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {
    internal var dialPhone: String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val firstName: Button = findViewById(R.id.firstNameD)
        val lastName: Button = findViewById(R.id.lastNameD)
        val phoneNumberD1: Button = findViewById(R.id.phoneNumberD)

        firstName.text = "First Name: " + intent.getStringExtra("firstName")
        lastName.text =  "Last Name: " + intent.getStringExtra("lastName")
        phoneNumberD1.text =  "Phone No: " + intent.getStringExtra("phoneNumber")

        dialPhone = intent.getStringExtra("phoneNumber").toString()


        phoneNumberD1.setOnClickListener{
            val intent: Intent = Intent(Intent.ACTION_DIAL, Uri.parse("Tel: " + Uri.encode(dialPhone)))

            startActivity(intent)
        }
    }
}