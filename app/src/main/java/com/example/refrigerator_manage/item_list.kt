package com.example.myfridgeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class item_list : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_list)

        val actionbar = supportActionBar
        actionbar!!.title = "Food List"
        actionbar.setDisplayHomeAsUpEnabled(true)
    }
}