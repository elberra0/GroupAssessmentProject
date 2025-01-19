package com.example.groupassessmentproject.services
import android.util.Log
import com.example.groupassessmentproject.models.DataApp

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PersistenceService  private constructor() {

    companion object {
        val shared by lazy { PersistenceService() }
    }

    fun load() {
        //dataApp.clear()
        //dataApp.addAll(getAll())
        getAll()
    }

    private fun getAll() {

        RetrofitInstance.apiService.getData().enqueue(object : Callback<DataApp> {
            override fun onResponse(call: Call<DataApp>, response: Response<DataApp>) {
                if (response.isSuccessful) {
                    var getResult =  response.body()

                }
            }

            override fun onFailure(call: Call<DataApp>, t: Throwable) {
                Log.e("MainActivity", "Failure: ${t.message}")
            }
        })

    }
}
