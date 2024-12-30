package com.example.groupassessmentproject.models
import com.fasterxml.jackson.annotation.JsonProperty

data class Suplemento(
    @JsonProperty("proteina_de_suero")
    val proteinaDeSuero: String,
    @JsonProperty("creatina_monomhidratada")
    val creatinaMonomhidratada: String,
    @JsonProperty("bcaas")
    val bcaas: String,
    @JsonProperty("multivitaminico")
    val multivitaminico: String
)