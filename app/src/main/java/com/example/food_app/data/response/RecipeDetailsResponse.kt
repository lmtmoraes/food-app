package com.example.food_app.data.response

import com.example.food_app.data.model.ExtendedIngredient
import com.example.food_app.data.model.WineParing
import com.google.gson.annotations.SerializedName

data class RecipeDetailsResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("imageType")
    val imageType: String,
    @SerializedName("servings")
    val servings: Int,
    @SerializedName("readyInMinutes")
    val readyInMinutes: Int,
    @SerializedName("license")
    val license: String,
    @SerializedName("sourceName")
    val sourceName: String,
    @SerializedName("sourceUrl")
    val sourceUrl: String,
    @SerializedName("spoonacularSourceUrl")
    val spoonacularSourceUrl: String,
    @SerializedName("aggregateLikes")
    val aggregateLikes: Int,
    @SerializedName("healthScore")
    val healthScore: Double,
    @SerializedName("spoonacularScore")
    val spoonacularScore: Double,
    @SerializedName("pricePerServing")
    val pricePerServing: Double,
    @SerializedName("analyzedInstructions")
    val analyzedInstructions: ArrayList<Any>,
    @SerializedName("cheap")
    val cheap: Boolean,
    @SerializedName("creditsText")
    val creditsText: String,
    @SerializedName("cuisines")
    val cuisines: ArrayList<Any>,
    @SerializedName("dairyFree")
    val dairyFree: Boolean,
    @SerializedName("diets")
    val diets: ArrayList<Any>,
    @SerializedName("gaps")
    val gaps: String,
    @SerializedName("glutenFree")
    val glutenFree: Boolean,
    @SerializedName("instructions")
    val instructions: String,
    @SerializedName("ketogenic")
    val ketogenic: Boolean,
    @SerializedName("lowFodmap")
    val lowFoodMap: Boolean,
    @SerializedName("occasions")
    val occasions: ArrayList<Any>,
    @SerializedName("sustainable")
    val sustainable: Boolean,
    @SerializedName("vegan")
    val vegan: Boolean,
    @SerializedName("vegetarian")
    val vegetarian: Boolean,
    @SerializedName("veryHealthy")
    val veryHealthy: Boolean,
    @SerializedName("veryPopular")
    val veryPopular: Boolean,
    @SerializedName("whole30")
    val whole30: Boolean,
    @SerializedName("weightWatcherSmartPoints")
    val weightWatcherSmartPoints: Int,
    @SerializedName("dishTypes")
    val dishTypes: ArrayList<String>,
    @SerializedName("extendedIngredients")
    val extendedIngredients: ArrayList<ExtendedIngredient>,
    @SerializedName("summary")
    val summary: String,
    @SerializedName("winePairing")
    val winePairing: WineParing
    )
