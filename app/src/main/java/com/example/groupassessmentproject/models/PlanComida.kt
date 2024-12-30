package com.example.groupassessmentproject.models
import com.fasterxml.jackson.annotation.JsonProperty
data class PlanComida(
    @JsonProperty("desayuno")
    val Desayuno: Almuerzo,
    @JsonProperty("merienda_pre_entrenamiento")
    val MeriendaPreEntrenamiento: Almuerzo,
    @JsonProperty("almuerzo_post_entrenamiento")
    val AlmuerzoPostEntrenamiento: Almuerzo,
    @JsonProperty("merienda_tarde")
    val MeriendaTarde: Almuerzo,
    @JsonProperty("cena")
    val Cena: Almuerzo,
    @JsonProperty("snack_nocturno")
    val SnackNocturno: Almuerzo
)
