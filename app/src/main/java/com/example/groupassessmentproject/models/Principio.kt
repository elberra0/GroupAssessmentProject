package com.example.groupassessmentproject.models
import com.fasterxml.jackson.annotation.JsonProperty

data class Principio(
    @JsonProperty("macronutrientes")
    val macronutrientes: Macronutriente,
    @JsonProperty("comidas")
    val comidas: Comida
)
