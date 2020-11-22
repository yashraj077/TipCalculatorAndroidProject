package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.tipcalculator.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun calculate(view: View) {

        var cost = binding.getCost.text.toString().toDoubleOrNull()

        if (cost==null){
            Toast.makeText(this, "Please enter amount", Toast.LENGTH_SHORT).show()
        }
        else {

            val tipPercent = when(binding.options.checkedRadioButtonId){
                R.id.option1 -> 0.20
                R.id.option2 -> 0.18
                else -> 0.15
            }

            var tip = cost*tipPercent

            if (binding.roundUp.isChecked){
                tip = kotlin.math.round(tip)
                Toast.makeText(this, "Tip $tip", Toast.LENGTH_LONG).show()
            }
            else {
                Toast.makeText(this, "Tip $tip", Toast.LENGTH_LONG).show()
            }
        }
    }
}