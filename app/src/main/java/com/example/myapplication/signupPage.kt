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
        val spinner:Spinner=findViewById(R.id.spinner)
        val adapter=ArrayAdapter.createFromResource(this,R.array.spinner_items,android.R.layout.simple_spinner_item)


        val calendar = Calendar.getInstance()
        val today=calendar.timeInMillis

        //calculate the date
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







        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter=adapter

        spinner.setSelection(0)
        spinner.onItemSelectedListener=object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if(position==0){
                    Toast.makeText(this@signupPage, "Item selected: $position", Toast.LENGTH_SHORT).show()

                }
                else{

                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }
        }
    }
}