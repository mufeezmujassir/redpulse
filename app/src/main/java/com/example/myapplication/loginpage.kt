package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class loginpage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginpage)
        val login:Button=findViewById(R.id.login);
        val signup:TextView=findViewById(R.id.signuptext)
        login.setOnClickListener{
            val intent= Intent(this@loginpage,homepage::class.java)
            startActivity(intent)
        }
        signup.setOnClickListener{
            val intent=Intent(this@loginpage,signupPage::class.java)
            startActivity(intent)
        }

    }
}