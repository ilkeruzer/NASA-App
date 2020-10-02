package com.ilkeruzer.nasa.ui.activity

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.TranslateAnimation
import androidx.appcompat.app.AppCompatActivity
import com.ilkeruzer.nasa.R
import com.ilkeruzer.nasa.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private val TRANSIT_TIME = 8000
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        backgroundAnim()
        iconAnim()
        openActivity()


    }

    private fun iconAnim() {
        val animation: Animation = AnimationUtils.loadAnimation(this, R.anim.animation)
        animation.duration = 10000
        binding.imageIcon.animation = animation
    }

    private fun openActivity() {
        val r = Runnable {
            goToMain()
        }
        Handler(Looper.myLooper()!!).postDelayed(r, TRANSIT_TIME.toLong())
    }

    private fun goToMain() {
        Intent(this,MainActivity::class.java).apply {
            startActivity(this)
            finish()
        }
    }

    private fun backgroundAnim() {
        val anim: ObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(
            binding.imageViewBackground,
            PropertyValuesHolder.ofFloat(View.SCALE_X, 1.2f),
            PropertyValuesHolder.ofFloat(View.SCALE_Y, 1.2f)
        )

        anim.repeatCount = 1
        anim.repeatMode = ValueAnimator.REVERSE
        anim.duration = 1000
        anim.start()

        val animation: Animation = TranslateAnimation(0F, 100F, 0F, 0F)
        animation.duration = 10000
        animation.fillAfter = true
        binding.imageViewBackground.startAnimation(animation)


    }
}