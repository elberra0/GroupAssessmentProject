package com.example.groupassessmentproject.models
import com.fasterxml.jackson.annotation.JsonProperty

class Almuerzo(
    @JsonProperty("alimentos")
    var alimentos: List<String>
)