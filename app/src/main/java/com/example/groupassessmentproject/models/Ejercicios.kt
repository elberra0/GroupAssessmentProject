package com.example.groupassessmentproject.models
import com.fasterxml.jackson.annotation.JsonProperty

data class Ejercicios(
    @JsonProperty("lunes") val Lunes: DiaSemanaBase,
    @JsonProperty("martes") val Martes: DiaSemanaBase,
    @JsonProperty("miercoles") val Miercoles: DiaSemanaBase,
    @JsonProperty("jueves") val Jueves: DiaSemanaBase,
    @JsonProperty("viernes") val Viernes: DiaSemanaBase,
    @JsonProperty("sabado") val Sabado: DiaSemanaBase,
    @JsonProperty("domingo") val Domingo: DiaSemanaBase
)
