package com.example.refrigerator_manage

import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.refrigerator_manage.databinding.ActivityFridgeManagerBinding

class FridgeManager : AppCompatActivity() {
    lateinit var binding: ActivityFridgeManagerBinding
    private var isFabOpen = false
    private lateinit var fridgeList : List<FridgeData>
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityFridgeManagerBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initFridge()
        initFloatingBtn()
        initViewPager()
    }

    private fun initViewPager() {
        val adapter = OuterFridgeAdapter(fridgeList)
        val viewPager = binding.viewPager
        viewPager.adapter = adapter
    }

    private fun initFridge() {
        //fridge db에서 가져오기
        fridgeList = mutableListOf(
            FridgeData("가상냉장고1", 5),
            FridgeData("두번째가상냉장고", 4)
        ) //테스트용
    }

    private fun initFloatingBtn(){
        setFABClickEvent()
    }

    private fun setFABClickEvent() {
        // 플로팅 버튼 클릭시 애니메이션 동작 기능
        binding.fabMain.setOnClickListener {
            toggleFab()
        }

        // 플로팅 버튼 클릭 이벤트 - 바코드 인식 혹은 제품 추가
        binding.fabScanbarcode.setOnClickListener {

        }

        // 플로팅 버튼 클릭 이벤트 - 냉장고 추가
        binding.fabAddfridge.setOnClickListener {
            val intent = Intent(this, AddFridge::class.java)
            startActivity(intent)
            finish()
        }


    }

    private fun toggleFab() {
        // 플로팅 액션 버튼 닫기 - 열려있는 플로팅 버튼 집어넣는 애니메이션
        if (isFabOpen) {
            ObjectAnimator.ofFloat(binding.fabAddfridge, "translationY", 0f).start()
            ObjectAnimator.ofFloat(binding.fabScanbarcode, "translationY", 0f).start()
            ObjectAnimator.ofFloat(binding.fabMain, View.ROTATION, 45f, 0f).start()
        } else { // 플로팅 액션 버튼 열기 - 닫혀있는 플로팅 버튼 꺼내는 애니메이션
            ObjectAnimator.ofFloat(binding.fabAddfridge, "translationY", -360f).start()
            ObjectAnimator.ofFloat(binding.fabScanbarcode, "translationY", -180f).start()
            ObjectAnimator.ofFloat(binding.fabMain, View.ROTATION, 0f, 45f).start()
        }

        isFabOpen = !isFabOpen

    }
}