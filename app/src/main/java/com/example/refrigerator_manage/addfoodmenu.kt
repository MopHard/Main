package com.example.myfridgeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class addfoodmenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addfoodmenu)

        val actionbar = supportActionBar
        actionbar!!.title = "Add Food Menu"
        actionbar.setDisplayHomeAsUpEnabled(true)

        init()
    }
    fun init(){
        val scanbtn = findViewById<ImageButton>(R.id.scanbtn)
        val savebtn = findViewById<ImageButton>(R.id.imageButton)


        scanbtn.setOnClickListener {
            val intent = Intent(this,barcode_scan::class.java)
            startActivity(intent)

        }
        savebtn.setOnClickListener {
            val intent = Intent(this,fridge_display::class.java)
            startActivity(intent)
        }
    }
}