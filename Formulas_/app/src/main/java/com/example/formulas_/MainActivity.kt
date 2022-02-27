package com.example.formulas_

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.BounceInterpolator
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashScreen = installSplashScreen() // Before setContentView
        setContentView(R.layout.activity_main)



        splashScreen.setOnExitAnimationListener { splashScreenProvider ->
            val splashScreenView = splashScreenProvider.view
            ObjectAnimator.ofFloat(
                splashScreenView,
                View.TRANSLATION_Y,
                0f,
                splashScreenView.height.toFloat()
            ).apply {
                interpolator = BounceInterpolator()
                duration = 1000L
                doOnEnd { splashScreenProvider.remove() }
                start()
            }
        }



    }
}