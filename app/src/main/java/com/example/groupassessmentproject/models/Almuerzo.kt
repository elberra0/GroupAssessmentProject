package com.example.groupassessmentproject.models
import com.google.gson.annotations.SerializedName

class Almuerzo(
    @SerializedName("alimentos")
    var alimentos: List<String>
)