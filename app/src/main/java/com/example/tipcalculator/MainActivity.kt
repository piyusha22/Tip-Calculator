package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.tipcalculator.R
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /** saves the reference to the TextView, Button, RadioGroup and Switch
         * object in a variable called costOfServiceText, calcButton, radioGroup, tipAmountText
         * respectively and finds them in the layout with its unique resource ID
         */
        val costOfServiceText: TextView = findViewById<TextView>(R.id.cost_of_service)
        val calcButton: Button = findViewById<Button>(R.id.calculate_button)
        val radioGroup: RadioGroup = findViewById<RadioGroup>(R.id.tip_options)
        val roundUpSwitch: Switch = findViewById<Switch>(R.id.round_up_switch)
        val tipAmountText: TextView = findViewById<TextView>(R.id.tip_result)

        //set a click listener on calcButton object by calling the setOnClickListener() method
        calcButton.setOnClickListener {

            /** retrieves the cost of a service from a text field, converts it to an integer, and
             * determines the tip percentage based on the selected radio button. The tip percentage
             * is assigned based on the ID of the selected radio button using a when expression */
            val cost = costOfServiceText.text.toString()
            val costAmount = cost.toInt()
            val checkRadioButton: Int = radioGroup.checkedRadioButtonId
            val tipPercent = when (checkRadioButton) {
                R.id.option_twenty_percent -> 0.20
                R.id.option_eighteen_percent -> 0.18
                R.id.option_fifteen_percent -> 0.15
                else -> 0.0
            }

            /**  tip amount is calculated based on the costAmount and tipPercent
             * If the roundUpSwitch is checked, round the tipAmount to the nearest integer and convert
             * back to a double. Then, set the text of the tipAmountText view to display the final tip amount */
            var tipAmount = costAmount * tipPercent
            if (roundUpSwitch.isChecked) {
                tipAmount = tipAmount.roundToInt().toDouble()
            }
            tipAmountText.text = "Tip Amount: $$tipAmount"
        }
    }
}