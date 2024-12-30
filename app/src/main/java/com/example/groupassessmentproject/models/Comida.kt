package com.example.groupassessmentproject.models
import com.fasterxml.jackson.annotation.JsonProperty
data class Comida(
    @JsonProperty("pre_post_entrenamiento")
    val prePostEntrenamiento: String,
    @JsonProperty("hidratacion")
    val hidratacion: String
)