package com.example.myfridgeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class cart_view : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cart_view)

        val actionbar = supportActionBar
        actionbar!!.title = "Cart View"
        actionbar.setDisplayHomeAsUpEnabled(true)
    }
}