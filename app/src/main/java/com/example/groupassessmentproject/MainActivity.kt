package com.example.groupassessmentproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity() {
    var currentUsername = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        currentUsername = intent.getStringExtra("username").toString()
        setContentView(R.layout.activity_main)
    }
}