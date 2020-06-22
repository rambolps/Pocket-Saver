package com.example.pocketsaver

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.widget.ImageView
import android.widget.TextView

class result : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var buyResult = intent.getBooleanExtra("buyResult",false)

        val resultView = findViewById<ImageView>(R.id.resultImage)
        val yesImage = resources.getIdentifier("@drawable/yes",null,this.packageName)
        val noImage = resources.getIdentifier("@drawable/no",null,this.packageName)

        if (buyResult) {
            resultView.setImageResource(yesImage)
        }
        else {
            resultView.setImageResource(noImage)
        }

    }
}
