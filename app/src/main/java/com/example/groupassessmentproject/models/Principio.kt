package com.example.groupassessmentproject.models
import com.google.gson.annotations.SerializedName

data class Principio(
    @SerializedName("macronutrientes")
    val macronutrientes: Macronutriente,
    @SerializedName("comidas")
    val comidas: Comida
)
