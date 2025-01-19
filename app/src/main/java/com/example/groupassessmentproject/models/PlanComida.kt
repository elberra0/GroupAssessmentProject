package com.example.groupassessmentproject.models

import com.google.gson.annotations.SerializedName

data class PlanComida(
    @SerializedName("desayuno")
    val Desayuno: Almuerzo,
    @SerializedName("merienda_pre_entrenamiento")
    val MeriendaPreEntrenamiento: Almuerzo,
    @SerializedName("almuerzo_post_entrenamiento")
    val AlmuerzoPostEntrenamiento: Almuerzo,
    @SerializedName("merienda_tarde")
    val MeriendaTarde: Almuerzo,
    @SerializedName("cena")
    val Cena: Almuerzo,
    @SerializedName("snack_nocturno")
    val SnackNocturno: Almuerzo
)
