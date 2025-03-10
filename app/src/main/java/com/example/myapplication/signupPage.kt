package com.example.myapplication

import android.app.DatePickerDialog
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

        val dobEditText: EditText = findViewById(R.id.dob)
        val gender: Spinner = findViewById(R.id.gender)
        val spinner: Spinner = findViewById(R.id.spinner)

        val adapter = ArrayAdapter.createFromResource(
            this, R.array.spinner_items, android.R.layout.simple_spinner_item
        )

        val genderAdapter = ArrayAdapter.createFromResource(
            this, R.array.spinner_gender, android.R.layout.simple_spinner_item
        )

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

        // Set adapters for spinners
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        gender.adapter = genderAdapter

        gender.setSelection(0)
        spinner.setSelection(0)

        gender.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (position == 0) {
                    Toast.makeText(this@signupPage, "Gender type", Toast.LENGTH_SHORT).show()
                } else {
                    // Handle other positions if necessary
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }
        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (position == 0) {
                    Toast.makeText(this@signupPage, "Blood type", Toast.LENGTH_SHORT).show()
                } else {
                    // Handle other positions if necessary
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }
        }


        val signup:Button=
    }
}
