package com.example.refrigerator_manage

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.refrigerator_manage.databinding.ActivityFirstLaunchBinding

class FirstLaunchActivity : AppCompatActivity() {
    lateinit var binding: ActivityFirstLaunchBinding
    lateinit var fadeIn : ObjectAnimator
    lateinit var fadeOut : ObjectAnimator
    private val textArr = arrayOf("처음 실행하셨네요!", "기본 냉장고를 설정해주세요!",)
    private var cnt = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityFirstLaunchBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initAnimation()
        binding.root.setOnClickListener{
            if(cnt < textArr.size){
                fadeOut.start()
            }else{
                val fadeOutActivity = ObjectAnimator.ofFloat(binding.root, "alpha", 1f, 0f)
                fadeOutActivity.duration = 700
                fadeOutActivity.addListener(object: Animator.AnimatorListener{
                    override fun onAnimationStart(p0: Animator?) {}
                    override fun onAnimationCancel(p0: Animator?) {}
                    override fun onAnimationRepeat(p0: Animator?) {}
                    override fun onAnimationEnd(p0: Animator?) {
                        val intent = Intent(applicationContext, AddFridge::class.java)
                        startActivity(intent)
                    }
                })
                fadeOutActivity.start()
            }
        }
    }
    private fun initAnimation() {
        fadeOut = ObjectAnimator.ofFloat(binding.infoText, "alpha", 1f, 0f)
        fadeOut.duration = 500
        fadeIn = ObjectAnimator.ofFloat(binding.infoText, "alpha", 0f, 1f)
        fadeIn.duration = 500

        fadeOut.addListener(object : Animator.AnimatorListener{
            override fun onAnimationRepeat(animator: Animator?) {}
            override fun onAnimationCancel(animator: Animator?) {}
            override fun onAnimationStart(animator: Animator?) {}
            override fun onAnimationEnd(animator: Animator?) {
                if(cnt < textArr.size){
                    binding.infoText.text = textArr[cnt]
                    cnt++
                }
                fadeIn.start()
            }
        })
    }
}