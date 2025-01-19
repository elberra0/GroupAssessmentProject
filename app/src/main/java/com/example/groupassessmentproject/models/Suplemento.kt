package com.example.groupassessmentproject.models

import com.google.gson.annotations.SerializedName

data class Suplemento(
    @SerializedName("proteina_de_suero")
    val proteinaDeSuero: String,
    @SerializedName("creatina_monomhidratada")
    val creatinaMonomhidratada: String,
    @SerializedName("bcaas")
    val bcaas: String,
    @SerializedName("multivitaminico")
    val multivitaminico: String
)