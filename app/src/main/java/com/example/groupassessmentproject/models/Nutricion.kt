package com.example.groupassessmentproject.models
import com.fasterxml.jackson.annotation.JsonProperty

data class Nutricion(
    @JsonProperty("principios")
    val Principios: Principio,
    @JsonProperty("plan_comidas")
    val PlanComidas: PlanComida,
    @JsonProperty("suplementos")
    val Suplementos: Suplemento
)