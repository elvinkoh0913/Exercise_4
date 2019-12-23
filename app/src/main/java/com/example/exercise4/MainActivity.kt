package com.example.exercise4

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DisplayDOB.setOnClickListener(){
            val c = Calendar.getInstance()
            val currentYear = c.get(Calendar.YEAR)
            val currentMonth = c.get(Calendar.MONTH)
            val currentDay = c.get(Calendar.DAY_OF_MONTH)

            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, day ->
                DisplayDOB.text = day.toString() + "/" + (month + 1).toString() + "/" + year.toString()
                var age = currentYear - year
                ageView.text = age.toString()
                var saving = getSaving(age).toString()
                savingView.text = getSaving(age).toString()

                transferSaving.text = (saving.toDouble() * 30.0 / 100.0).toString()
            }, currentYear, currentMonth, currentDay)
            dpd.show()
        }
    }

    fun getSaving (age: Int): Double{
        when (age){
            in 16..20 -> return 5000.00
            in 21..25 -> return 14000.00
            in 26..30 -> return 29000.00
            in 31..35 -> return 50000.00
            in 36..40 -> return 78000.00
            in 41..45 -> return 116000.00
            in 46..50 -> return 165000.00
            in 51..55 -> return 228000.00
            else -> return 0.0
        }
    }

}
