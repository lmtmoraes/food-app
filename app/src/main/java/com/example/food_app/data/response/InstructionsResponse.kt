package com.example.food_app.data.response

import com.example.food_app.data.model.Step
import com.google.gson.annotations.SerializedName

data class InstructionsResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("steps")
    val steps: ArrayList<Step>
)