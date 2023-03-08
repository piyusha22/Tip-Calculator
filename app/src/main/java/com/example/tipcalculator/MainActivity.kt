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

        val costOfServiceText: TextView = findViewById<TextView>(R.id.cost_of_service)
        val calcButton: Button = findViewById<Button>(R.id.calculate_button)
        val radioGroup: RadioGroup = findViewById<RadioGroup>(R.id.tip_options)
        val roundUpSwitch: Switch = findViewById<Switch>(R.id.round_up_switch)
        val tipAmountText: TextView = findViewById<TextView>(R.id.tip_result)

        calcButton.setOnClickListener {
            val cost = costOfServiceText.text.toString()
            val costAmount = cost.toInt()
            val checkRadioButton: Int = radioGroup.checkedRadioButtonId
            val tipPercent = when (checkRadioButton) {
                R.id.option_twenty_percent -> 0.20
                R.id.option_eighteen_percent -> 0.18
                R.id.option_fifteen_percent -> 0.15
                else -> 0.0
            }

            var tipAmount = costAmount * tipPercent
            if (roundUpSwitch.isChecked) {
                tipAmount = tipAmount.roundToInt().toDouble()
            }
            tipAmountText.text = "Tip Amount: $$tipAmount"
        }
    }
}