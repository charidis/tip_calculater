package com.example.tip_calculater
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tip_calculater.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener{calculateTip()}
    }
    private fun calculateTip(){
        val cost = binding.costOfService.text.toString().toDouble()
        val selectedId = binding.tipOptions.checkedRadioButtonId
        val tipPercentage = when (selectedId) {
            R.id.option_10_percent -> 0.10
            R.id.option_7_percent -> 0.07
            else -> 0.05
        }
        var tip =cost*tipPercentage
        val currencyTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipAmount.text = getString(R.string.tip_amount, currencyTip)
    }
}