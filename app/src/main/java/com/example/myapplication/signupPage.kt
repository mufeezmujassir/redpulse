package com.example.myapplication

import android.app.DatePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi

class signupPage : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_page)
       val signup:Button=findViewById(R.id.signup)
        val dobEditText: EditText = findViewById(R.id.dob)
        val gender: Spinner = findViewById(R.id.gender)
        val spinner: Spinner = findViewById(R.id.bloodtype)
        val logintext:TextView=findViewById(R.id.logintext)




        val calendar = Calendar.getInstance()
        val today = calendar.timeInMillis

        // Calculate the date
        calendar.add(Calendar.YEAR, -18)
        val eighteenYearsAgo = calendar.timeInMillis

        dobEditText.setOnClickListener {
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            // Create and show the DatePickerDialog
            val datePickerDialog = DatePickerDialog(
                this@signupPage,
                { _, selectedYear, selectedMonth, selectedDay ->
                    // Format the selected date and set it to the EditText
                    val formattedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                    dobEditText.setText(formattedDate)
                },
                year, month, day
            )
            datePickerDialog.datePicker.maxDate = eighteenYearsAgo
            datePickerDialog.show()
        }







        signup.setOnClickListener{
            val intent=Intent(this@signupPage,loginpage::class.java)
            startActivity(intent)
        }
        logintext.setOnClickListener{
            val intent=Intent(this@signupPage,loginpage::class.java)
            startActivity(intent)
        }


    }
}
