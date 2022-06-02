package com.example.myfridgeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class barcode_scan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.barcode_scan)

        val actionbar = supportActionBar
        actionbar!!.title = "Barcode Scan"
        actionbar.setDisplayHomeAsUpEnabled(true)
    }
}