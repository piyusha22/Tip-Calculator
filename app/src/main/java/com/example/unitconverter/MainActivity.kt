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

        /** saves the reference to the Button, EditText, RadioGroup, TextView and Switch
         * object in a variable called unitBtn, unitNum, unitOptions, unitResult and unitReverse
         * respectively and finds them in the layout with its unique resource ID
         */
        val unitBtn : Button = findViewById<Button>(R.id.convert_button)
        val unitNum : EditText = findViewById<EditText>(R.id.unit)
        val unitOptions : RadioGroup = findViewById<RadioGroup>(R.id.unit_options)
        val unitResult : TextView = findViewById<TextView>(R.id.result)
        val unitReverse : Switch = findViewById<Switch>(R.id.reverse_switch)

        //set a click listener on unitBtn object by calling the setOnClickListener() method
        unitBtn.setOnClickListener(View.OnClickListener {

            /** retrieves the selected unit conversion option from the unitOptions radio group.
             * Based on the selected option and the state of the unitReverse switch, it performs the
             * corresponding unit conversion calculation using the value entered in the unitNum field.
             * The calculated result is displayed in the unitResult text view. If a NumberFormatException
             * occurs during the conversion, an error message is logged. */
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