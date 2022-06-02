package com.example.myfridgeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class main_activity : AppCompatActivity() {;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    fun init(){
        val cartbtn = findViewById<ImageButton>(R.id.cartbtn)
        val fridge1btn = findViewById<ImageButton>(R.id.fridgebtn1)
        val fridge2btn = findViewById<ImageButton>(R.id.fridgebtn2)
        val fridge3btn = findViewById<ImageButton>(R.id.fridgebtn3)
        val addfridgebtn = findViewById<ImageButton>(R.id.imageButton4)


        cartbtn.setOnClickListener {
            val intent = Intent(this,cart_view::class.java)
            startActivity(intent)

        }

        fridge1btn.setOnClickListener {
            val intent = Intent(this,fridge_display::class.java)
            startActivity(intent)

        }
        fridge2btn.setOnClickListener {

        }
        fridge3btn.setOnClickListener {

        }
        addfridgebtn.setOnClickListener {

        }


    }
}