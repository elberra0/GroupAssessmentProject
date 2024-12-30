package com.example.groupassessmentproject.models
import com.fasterxml.jackson.annotation.JsonProperty

data class DiaSemanaBase(
    @JsonProperty("tipo")
    val Tipo: String,
    @JsonProperty("calentamiento")
    val Calentamiento: String?,
    @JsonProperty("ejercicios")
    val Ejercicios: List<Ejercicio>,
    @JsonProperty("enfriamiento")
    val Enfriamiento: String?
)