package com.example.myfridgeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView

class fridge_display : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fridge_display)

        val actionbar = supportActionBar
        actionbar!!.title = "Fridge Display"
        actionbar.setDisplayHomeAsUpEnabled(true)

        init()
    }

    fun init(){
        val foodlistbtn = findViewById<ImageButton>(R.id.itemlistbtn)
        val addfoodbtn = findViewById<ImageButton>(R.id.addfoodbtn)
        val item1 = findViewById<ImageView>(R.id.itemImage1)
        val item2 = findViewById<ImageView>(R.id.itemImage2)
        val item3 = findViewById<ImageView>(R.id.itemImage3)

        foodlistbtn.setOnClickListener {
            val intent = Intent(this,item_list::class.java)
            startActivity(intent)

        }

        item1.setOnClickListener {
            val intent = Intent(this,shelf_item_list::class.java)
            startActivity(intent)
        }

        item2.setOnClickListener {
            val intent = Intent(this,shelf_item_list::class.java)
            startActivity(intent)
        }

        item3.setOnClickListener {
            val intent = Intent(this,shelf_item_list::class.java)
            startActivity(intent)
        }

        addfoodbtn.setOnClickListener {
            val intent = Intent(this,addfoodmenu::class.java)
            startActivity(intent)
        }
    }




}