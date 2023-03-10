package com.example.unitconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val unitBtn : Button = findViewById<Button>(R.id.convert_button)
        val unitNum : EditText = findViewById<EditText>(R.id.unit)
        val unitOptions : RadioGroup = findViewById<RadioGroup>(R.id.unit_options)
        val unitResult : TextView = findViewById<TextView>(R.id.result)
        val unitReverse : Switch = findViewById<Switch>(R.id.reverse_switch)

        unitBtn.setOnClickListener(View.OnClickListener {
            var converted = 0f
            val unitOptionsId: Int = unitOptions.checkedRadioButtonId
            try {
                if (unitOptionsId != -1) {
                    val radioButton: RadioButton = findViewById<RadioButton>(unitOptionsId)
                    val rbValue: String = radioButton.text.toString()
                    if (rbValue == "Milliliters to fluid ounces" && !unitReverse.isChecked()) {
                        converted = unitNum.text.toString().toFloat() * 0.033814f
                    } else if (rbValue == "Milliliters to fluid ounces" && unitReverse.isChecked()) {
                        converted = unitNum.text.toString().toFloat() / 0.033814f
                    }else if (rbValue == "Grams to cups" && !unitReverse.isChecked()) {
                        converted = unitNum.text.toString().toFloat() / 240
                    } else if (rbValue == "Grams to cups" && unitReverse.isChecked()) {
                        converted = unitNum.text.toString().toFloat() * 240
                    }
                }
                unitResult.text = "Result: $converted"
            } catch (e: NumberFormatException) {
                Log.d("error", "Error while converting number")
            }
        })
    }
}