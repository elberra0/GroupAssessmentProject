package com.example.groupassessmentproject.models
import com.fasterxml.jackson.annotation.JsonProperty
data class Ejercicio(
    @JsonProperty("nombre")
    var nombre: String? = null,
    @JsonProperty("series")
    var series: Long? = null,
    @JsonProperty("repeticiones")
    var repeticiones: String? = null,
    @JsonProperty("descripcion")
    var descripcion: String? = null
)