package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class startPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_page)  // Set the content view first

        // Now, find the views after setting the content view
        val login: Button = findViewById(R.id.login)
        val signup: Button = findViewById(R.id.signup)

        // Set onClick listeners after the views are initialized
        login.setOnClickListener {
            val intent = Intent(this@startPage, loginpage::class.java)
            startActivity(intent)
        }

        signup.setOnClickListener {
            val intent = Intent(this@startPage, signupPage::class.java)
            startActivity(intent)
        }
    }
}
