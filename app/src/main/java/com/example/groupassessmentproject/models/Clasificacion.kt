package com.example.groupassessmentproject.models
import com.google.gson.annotations.SerializedName

data class Clasificacion(
    @SerializedName("id") val id: Int,
    @SerializedName("puntajeminimo") val puntajeMinimo: Int,
    @SerializedName("puntajemaximo") val puntajeMaximo: Int,
    @SerializedName("descripcion") val descripcion: String,
    @SerializedName("nombre") val nombre: String
)
