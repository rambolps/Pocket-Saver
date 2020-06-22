package com.example.pocketsaver

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_welcome.*
import kotlin.random.Random
import android.widget.SeekBar


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var name = intent.getStringExtra("user")


        val conbutton = findViewById<Button>(R.id.contact)
        val quickbutton = findViewById<Button>(R.id.quick)
        val analysisbutton = findViewById<Button>(R.id.analysis)
        val userName = findViewById<TextView>(R.id.name)
        val setbutton = findViewById<ImageButton>(R.id.setting)

       conbutton .setOnClickListener {
            val conIntent = Intent(this, contactActivity :: class.java)
            startActivity(conIntent)
        }

        quickbutton.setOnClickListener {
            val quickIntent = Intent(this, quickActivity :: class.java)
            startActivity(quickIntent)
        }
        analysisbutton.setOnClickListener {
           val analysisIntent = Intent(this, analysisActivity :: class.java)
           startActivity(analysisIntent)
        }

        setbutton.setOnClickListener{
          val setIntent = Intent(this, settingActivity :: class.java)
           startActivity(setIntent)
       }

        userName.setText("Welcome "+name)


    }

}
