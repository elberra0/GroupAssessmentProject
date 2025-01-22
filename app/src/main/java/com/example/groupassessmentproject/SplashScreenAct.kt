package com.example.groupassessmentproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import android.os.Bundle
import com.example.groupassessmentproject.databinding.ActivitySplashScreenBinding

class SplashScreenAct : AppCompatActivity(){
    private val view by lazy {
        ActivitySplashScreenBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val screenSplash = installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        screenSplash.setKeepOnScreenCondition{true}

        val intent = Intent(this,LoginSignInActivity::class.java)
        startActivity(intent)
        finish()
    }
}