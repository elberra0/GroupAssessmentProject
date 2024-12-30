package com.example.groupassessmentproject.models
import com.fasterxml.jackson.annotation.JsonProperty

data class Clasificacion(
    @JsonProperty("id") val id: Int,
    @JsonProperty("puntajeminimo") val puntajeMinimo: Int,
    @JsonProperty("puntajemaximo") val puntajeMaximo: Int,
    @JsonProperty("descripcion") val descripcion: String,
    @JsonProperty("nombre") val nombre: String

)
