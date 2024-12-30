package com.example.groupassessmentproject.models
import com.fasterxml.jackson.annotation.JsonProperty
data class Macronutriente(
    @JsonProperty("carbohidratos")
    val Carbohidratos: String,
    @JsonProperty("proteinas")
    val Proteinas: String,
    @JsonProperty("grasas")
    val Grasas: String
)
