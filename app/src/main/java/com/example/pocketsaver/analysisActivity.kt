package com.example.pocketsaver

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import kotlin.math.exp

class analysisActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_analysis)

        val price = findViewById<EditText>(R.id.aprice)
        val expense = findViewById<EditText>(R.id.aexpense)
        val avail = findViewById<EditText>(R.id.avail)
        val life = findViewById<EditText>(R.id.life)
        val income = findViewById<EditText>(R.id.income)
        val want = findViewById<SeekBar>(R.id.awant)
        val wantresult = findViewById<TextView>(R.id.awantresult)
        val calculate = findViewById<Button>(R.id.acalculate)


        wantresult.text = "Want: "+(want.progress+1).toString()

        want.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(sseekBar: SeekBar, progress: Int, fromUser: Boolean) {
                wantresult.text = "Want: "+(progress+1).toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}

            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        calculate.setOnClickListener {
            if (price.text.toString().isBlank() || expense.text.toString().isBlank() || avail.text.toString().isBlank() || life.text.toString().isBlank() || income.text.toString().isBlank())
            {
               d("Black","Yes")
            }
            else
            {
                var saving = 0.0
                var buy = false
                var budget = 0.0
                
                var cost = price.text.toString().toFloat() + expense.text.toString().toFloat()
                
                budget += income.text.toString().toFloat()
                
                saving = life.text.toString().toDouble()
                
                if(saving < 5)
                {

                }
                else if (saving < 7)
                {
                    budget += (avail.text.toString().toFloat()*.25)
                }
                else if (saving < 10)
                {
                    budget += (avail.text.toString().toFloat()*.5)
                }
                else if (saving < 15)
                {
                    budget += (avail.text.toString().toFloat()*.75)
                }
                else
                {
                    budget += avail.text.toString().toFloat()
                }

                
                var leftOver = budget-cost
                var budgetPercent = (leftOver/budget)*100

                d("LeftOver", leftOver.toString())
                d("BudgetPercent", budgetPercent.toString())

                if (leftOver <= 0) {
                    buy = false
                } else {
                    when (want.progress + 1) {
                        1 -> buy = (budgetPercent >= 90)

                        2 -> buy = (budgetPercent >= 80)

                        3 -> buy = (budgetPercent >= 70)


                        4 -> buy = (budgetPercent >= 60)


                        5 -> buy = (budgetPercent >= 50)


                        6 -> buy = (budgetPercent >= 40)


                        7 -> buy = (budgetPercent >= 30)


                        8 -> buy = (budgetPercent >= 20)


                        9 -> buy = (budgetPercent >= 10)


                        10 -> buy = (budgetPercent >= 5)
                    }
                }

                val resultIntent = Intent(this, result::class.java)
                resultIntent.putExtra("buyResult", buy)
                d("Result", buy.toString())
                startActivity(resultIntent)
            }
        }
    }
}
