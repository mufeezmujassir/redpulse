@file:Suppress("DEPRECATION")

package com.example.myapplication

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //find the view
        val textView: TextView = findViewById(R.id.textView)
        val imageView:ImageView=findViewById(R.id.imageView)
        val largeimage:ImageView=findViewById(R.id.imageLargeView)
        val button:Button=findViewById(R.id.button)
        // Initially, set the small image and text to be invisible
        imageView.visibility = View.INVISIBLE
        textView.visibility = View.INVISIBLE

        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        val fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out)

        largeimage.startAnimation(fadeIn)

        Handler().postDelayed({

            largeimage.startAnimation(fadeOut)
            largeimage.visibility=View.INVISIBLE



            textView.startAnimation(fadeIn)
            imageView.startAnimation(fadeIn)
            button.startAnimation(fadeIn)
            button.visibility=View.VISIBLE
            imageView.visibility=View.VISIBLE
            textView.visibility = View.VISIBLE
        }, 1000) // 2000 milliseconds = 2 seconds
    }
}