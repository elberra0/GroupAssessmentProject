package com.example.groupassessmentproject.models.remote

data class DayPlan(
    val tipo: String,
    val calentamiento: String,
    val ejercicios: List<Exercise>,
    val enfriamiento: String?
)