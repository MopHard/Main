package com.example.myfridgeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class shelf_item_list : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shelf_item_list)

        val actionbar = supportActionBar
        actionbar!!.title = "Shelf item List"
        actionbar.setDisplayHomeAsUpEnabled(true)
    }
}