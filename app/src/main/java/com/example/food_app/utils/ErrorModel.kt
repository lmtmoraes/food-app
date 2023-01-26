package com.example.food_app.utils

import com.google.gson.annotations.SerializedName

data class ErrorModel(
    @SerializedName("message")
    val error: String? = ""
)