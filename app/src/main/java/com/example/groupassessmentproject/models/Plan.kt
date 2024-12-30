package com.example.groupassessmentproject.models
import com.fasterxml.jackson.annotation.JsonProperty

data class Plan(
    @JsonProperty("id")
    val id: Int,
    @JsonProperty("clasificacionid")
    val clasificacionId: Int,
    @JsonProperty("ejercicios")
    val ejercicios: Ejercicios,
    @JsonProperty("consejos")
    val consejos: List<String>,
    @JsonProperty("nutricion")
    val nutricion: Nutricion
)