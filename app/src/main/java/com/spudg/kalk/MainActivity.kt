package com.spudg.kalk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.spudg.kalk.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bindingMain: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMain = ActivityMainBinding.inflate(layoutInflater)
        val view = bindingMain.root
        setContentView(view)

    setUpCalculatorList()

    }

    private fun setUpCalculatorList() {
        val calculators: ArrayList<CalculatorModel> = ArrayList()
        calculators.add(CalculatorModel("Mortgage",R.drawable.mortgage))
        calculators.add(CalculatorModel("Loan",R.drawable.loan))
        calculators.add(CalculatorModel("Compound Interest",R.drawable.compound_interest))
        calculators.add(CalculatorModel("Investment Return",R.drawable.investment_return))
        calculators.add(CalculatorModel("Percentage",R.drawable.percentage))
        val manager = LinearLayoutManager(this)
        bindingMain.rvCalculators.layoutManager = manager
        val calcAdapter = CalculatorAdapter(this, calculators)
        bindingMain.rvCalculators.adapter = calcAdapter
    }

}
