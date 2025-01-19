package com.example.groupassessmentproject.models
import com.google.gson.annotations.SerializedName

data class Ejercicios(
    @SerializedName("lunes") val Lunes: DiaSemanaBase,
    @SerializedName("martes") val Martes: DiaSemanaBase,
    @SerializedName("miercoles") val Miercoles: DiaSemanaBase,
    @SerializedName("jueves") val Jueves: DiaSemanaBase,
    @SerializedName("viernes") val Viernes: DiaSemanaBase,
    @SerializedName("sabado") val Sabado: DiaSemanaBase,
    @SerializedName("domingo") val Domingo: DiaSemanaBase
)
