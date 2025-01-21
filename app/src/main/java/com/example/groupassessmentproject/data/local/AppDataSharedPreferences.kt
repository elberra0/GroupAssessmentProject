package com.example.groupassessmentproject.data.local
import android.content.Context
import android.content.SharedPreferences

class AppDataSharedPreferences {
    fun saveJson(context: Context, json: String) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("jsonAppData", Context.MODE_PRIVATE)
        sharedPreferences.edit().putString("jsonAppData", json).apply()
    }

    fun getJson(context: Context): String? {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("jsonAppData", Context.MODE_PRIVATE)
        return sharedPreferences.getString("jsonAppData", null)
    }

    fun savePlan(context: Context, planId: Int) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("planId", Context.MODE_PRIVATE)
        sharedPreferences.edit().putInt ("planId", planId).apply()
    }

    fun getPlan(context: Context): Int {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("planId", Context.MODE_PRIVATE)
        return sharedPreferences.getInt("planId", 0)
    }
}