package com.example.food_app.data.model

import com.google.gson.annotations.SerializedName

data class Ingredient(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("localizedName")
    val localizedName: String,
    @SerializedName("image")
    val image: String
)
