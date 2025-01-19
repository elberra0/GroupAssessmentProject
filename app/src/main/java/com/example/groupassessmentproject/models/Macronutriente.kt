package com.example.groupassessmentproject.models

import com.google.gson.annotations.SerializedName

data class Macronutriente(
    @SerializedName("carbohidratos")
    val Carbohidratos: String,
    @SerializedName("proteinas")
    val Proteinas: String,
    @SerializedName("grasas")
    val Grasas: String
)
