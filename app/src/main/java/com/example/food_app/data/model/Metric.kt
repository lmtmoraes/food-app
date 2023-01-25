package com.example.food_app.data.model

import com.google.gson.annotations.SerializedName

data class Metric(
    @SerializedName("amount")
    val amount: Double,
    @SerializedName("unitShort")
    val unitShort: String,
    @SerializedName("unitLong")
    val unitLong: String
)
