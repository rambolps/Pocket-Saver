package com.example.pocketsaver

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView

class quickActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quick)

        val want = findViewById<SeekBar>(R.id.Need)
        val wantresult = findViewById<TextView>(R.id.wantresult)
        val gobutton = findViewById<Button>(R.id.go)
        val result = findViewById<TextView>(R.id.result)
        val expenses = findViewById<EditText>(R.id.qoexpenses)
        val price = findViewById<EditText>(R.id.qprice)
        val budget = findViewById<EditText>(R.id.qbudget)

        wantresult.text = "Want: "+(want.progress+1).toString()

        want.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(sseekBar: SeekBar, progress: Int, fromUser: Boolean) {
                wantresult.text = "Want: "+(progress+1).toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}

            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        gobutton.setOnClickListener {

            if (budget.text.toString().isBlank()|| expenses.text.toString().isBlank()|| price.text.toString().isBlank())
            {
                result.text = "Please Enter All Info"
            }
            else {
                var leftOver = budget.text.toString().toFloat() - (expenses.text.toString().toFloat() + price.text.toString().toFloat())
                var budgetPercent = (leftOver/(budget.text.toString().toFloat())) * 100


                d("LeftOver", leftOver.toString())
                d("BudgetPercent", budgetPercent.toString())
                if (leftOver <= 0) {
                    result.text = "No"
                } else {
                    when (want.progress+1)
                    {
                        1 -> if (budgetPercent >= 90)
                        {
                            result.text = "Yes"
                        }
                        else
                        {
                        result.text = "No"
                    }

                        2 -> if (budgetPercent >= 80)
                        {
                            result.text = "Yes"
                        }
                        else
                        {
                            result.text = "No"
                        }

                        3 -> if (budgetPercent >= 70)
                        {
                            result.text = "Yes"
                        }
                        else
                        {
                            result.text = "No"
                        }

                        4 -> if (budgetPercent >= 60)
                        {
                            result.text = "Yes"
                        }
                        else
                        {
                            result.text = "No"
                        }

                        5 -> if (budgetPercent >= 50)
                        {
                            result.text = "Yes"
                        }
                        else
                        {
                            result.text = "No"
                        }

                        6 -> if (budgetPercent >= 40)
                        {
                            result.text = "Yes"
                        }
                        else
                        {
                            result.text = "No"
                        }

                        7 -> if (budgetPercent >= 30)
                        {
                            result.text = "Yes"
                        }
                        else
                        {
                            result.text = "No"
                        }

                        8 -> if (budgetPercent >= 20)
                        {
                            result.text = "Yes"
                        }
                        else
                        {
                            result.text = "No"
                        }

                        9 -> if (budgetPercent >= 10)
                        {
                            result.text = "Yes"
                        }
                        else
                        {
                            result.text = "No"
                        }

                        10 -> if (budgetPercent >= 5)
                        {
                            result.text = "Yes"
                        }
                        else
                        {
                            result.text = "No"
                        }
                    }
                }
            }
        }


    }
}
