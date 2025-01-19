package com.example.groupassessmentproject.models
import com.google.gson.annotations.SerializedName

data class DiaSemanaBase(
    @SerializedName("tipo")
    val Tipo: String,
    @SerializedName("calentamiento")
    val Calentamiento: String?,
    @SerializedName("ejercicios")
    val Ejercicios: List<Ejercicio>,
    @SerializedName("enfriamiento")
    val Enfriamiento: String?
)