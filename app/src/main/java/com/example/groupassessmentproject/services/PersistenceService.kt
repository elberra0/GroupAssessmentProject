package com.example.groupassessmentproject.services
import android.util.Log
import com.example.groupassessmentproject.models.DataApp

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PersistenceService
private constructor() {

    companion object {
        val shared by lazy { PersistenceService() }
    }

    fun load(): DataApp {
      return  getAll()
    }

    private fun getAll():DataApp {
        var result: DataApp = DataApp()

        return  result
    }
}
