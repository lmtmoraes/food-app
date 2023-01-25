package com.example.food_app.data.model

import com.google.gson.annotations.SerializedName

data class Step(
    @SerializedName("number")
    val number: String,
    @SerializedName("step")
    val step: String,
    @SerializedName("ingredients")
    val ingredients: ArrayList<Ingredient>,
    @SerializedName("equipment")
    val equipment: ArrayList<Equipment>,
    @SerializedName("length")
    val length: Length
)
