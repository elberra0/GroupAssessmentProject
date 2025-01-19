package com.example.groupassessmentproject.models

import com.google.gson.annotations.SerializedName

data class Plan(
    @SerializedName("id")
    val id: Int,
    @SerializedName("clasificacionid")
    val clasificacionId: Int,
    @SerializedName("ejercicios")
    val ejercicios: Ejercicios,
    @SerializedName("consejos")
    val consejos: List<String>,
    @SerializedName("nutricion")
    val nutricion: Nutricion
)