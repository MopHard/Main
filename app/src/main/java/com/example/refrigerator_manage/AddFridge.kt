package com.example.refrigerator_manage

import android.content.Intent
import android.content.SharedPreferences
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Color.blue
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.widget.addTextChangedListener
import com.example.refrigerator_manage.databinding.ActivityAddFridgeBinding
import java.util.*

class AddFridge : AppCompatActivity() {
    private val PREFSNAME = "UserInfo"
    lateinit var binding : ActivityAddFridgeBinding
    lateinit var editTexts : Array<EditText>
    lateinit var layouts : Array<LinearLayout>
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAddFridgeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initLayout()
    }

    private fun initLayout() {
        binding.apply{
            editTexts = arrayOf(floorText,nameText)
            layouts = arrayOf(firstLayout,secondLayout,lastLayout)
        }
        editTexts.forEachIndexed{
            i,element->

            var timer = Timer()
            element.addTextChangedListener{
                timer.cancel()
                timer = Timer()
                timer.schedule(
                    object : TimerTask(){
                        override fun run() {
                            runOnUiThread {
                                if(i < layouts.size - 1)
                                    layouts[i+1].visibility = View.VISIBLE
                            }
                        }
                    }, 1000
                )
            }
            element.setOnClickListener {
                var idx = i
                while(idx < layouts.size - 1){
                    layouts[++idx].visibility = View.GONE
                }
            }
            element.setOnFocusChangeListener {
                    view, b ->
                if(b){
                    element.backgroundTintList = ColorStateList.valueOf(Color.BLUE)
                }else{
                    element.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                }

            }
        }

        binding.finishBtn.setOnClickListener {
            val pref = getSharedPreferences(PREFSNAME, MODE_PRIVATE)
            val editor: SharedPreferences.Editor = pref.edit()
            editor.putBoolean("FIRST_SETUP", true)
            editor.commit()

            val intent = Intent(this, FridgeManager::class.java)
            intent.putExtra("fridgeData",
                FridgeData(
                    binding.nameText.text.toString(),
                    binding.floorText.text.toString().toInt()
                )
            )
            startActivity(intent)
            finish()
        }
    }
}