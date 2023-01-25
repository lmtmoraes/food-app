package com.example.food_app.data.response

import com.example.food_app.data.model.Recipe
import com.google.gson.annotations.SerializedName

data class RandomRecipesResponse(
    @SerializedName("recipes")
    val recipes: ArrayList<Recipe>
)
