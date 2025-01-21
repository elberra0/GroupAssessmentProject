package com.example.groupassessmentproject.models.remote

data class Nutrition(
    val principios: Principles,
    val plan_comidas: Map<String, Meal>
)
