package com.example.groupassessmentproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.groupassessmentproject.databinding.ActivityLoginSigninBinding

class LoginSignInActivity : AppCompatActivity() {
    private val view by lazy { ActivityLoginSigninBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)
    }
}