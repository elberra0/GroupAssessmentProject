package com.example.groupassessmentproject.models

import com.google.gson.annotations.SerializedName

data class Comida(
    @SerializedName("pre_post_entrenamiento")
    val prePostEntrenamiento: String,
    @SerializedName("hidratacion")
    val hidratacion: String
)