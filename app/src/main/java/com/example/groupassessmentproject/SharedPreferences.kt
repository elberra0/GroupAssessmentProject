package com.example.groupassessmentproject

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

class SharedPreferences_(context: Context) {

    private val masterKey = MasterKey.Builder(context)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    private val sharedPreferences = EncryptedSharedPreferences.create(
        context,
        "secure_prefs",
        masterKey,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    fun saveCredentials(username: String, password: String) {
        sharedPreferences.edit().putString(username, password).apply()
    }

    fun getPassword(username: String): String? {
        return sharedPreferences.getString(username, null)
    }
    fun checkUserExists(username: String): Boolean {
        return sharedPreferences.contains(username)
    }

    fun deleteUser(username: String) {
        sharedPreferences.edit().remove(username).apply()
    }
}