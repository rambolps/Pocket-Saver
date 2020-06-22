package com.example.pocketsaver

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_welcome.*
import org.w3c.dom.Text

class welcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val userName = findViewById<EditText>(R.id.userName)
        val startbutton = findViewById<Button>(R.id.getstarted)

        startbutton.setOnClickListener {
            var user = userName.text.toString()
            val mainIntent = Intent(this, MainActivity :: class.java)
            mainIntent.putExtra("user",user)
            startActivity(mainIntent)
        }


    }

}
