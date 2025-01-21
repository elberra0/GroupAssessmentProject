package com.example.groupassessmentproject.models.remote

data class WorkoutPlan(
    val id: Int,
    val clasificacionid: Int,
    val clasificacion: String,
    val ejercicios: Map<String, DayPlan>,
    val consejos: List<String>,
    val nutricion: Nutrition
)
