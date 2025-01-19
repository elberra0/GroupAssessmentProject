package com.example.groupassessmentproject.models

import com.google.gson.annotations.SerializedName

data class Nutricion(
    @SerializedName("principios")
    val Principios: Principio,
    @SerializedName("plan_comidas")
    val PlanComidas: PlanComida,
    @SerializedName("suplementos")
    val Suplementos: Suplemento
)