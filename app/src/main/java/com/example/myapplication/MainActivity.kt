@file:Suppress("DEPRECATION")

package com.example.myapplication

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the TextView
        val textView: TextView = findViewById(R.id.textView)

        // Use a Handler to delay the visibility of the TextView
        Handler().postDelayed({
            val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
            textView.startAnimation(fadeIn)
            textView.visibility = View.VISIBLE
        }, 20000) // 2000 milliseconds = 2 seconds
    }
}