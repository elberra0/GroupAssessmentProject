package com.example.groupassessmentproject.models

import com.google.gson.annotations.SerializedName

data class Ejercicio(
    @SerializedName("nombre")
    var nombre: String? = null,
    @SerializedName("series")
    var series: Long? = null,
    @SerializedName("repeticiones")
    var repeticiones: String? = null,
    @SerializedName("descripcion")
    var descripcion: String? = null
)