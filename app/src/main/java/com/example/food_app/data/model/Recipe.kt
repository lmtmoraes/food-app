package com.example.food_app.data.model

import com.google.gson.annotations.SerializedName
import java.util.*
import kotlin.collections.ArrayList

data class Recipe(
    @SerializedName("vegetarian")
    val vegetarian: Boolean,
    @SerializedName("vegan")
    val vegan: Boolean,
    @SerializedName("gluenFree")
    val glutenFree: Boolean,
    @SerializedName("dairyFree")
    val dairyFree: Boolean,
    @SerializedName("veryHealthy")
    val veryHealthy: Boolean,
    @SerializedName("cheap")
    val cheap: Boolean,
    @SerializedName("veryPopular")
    val veryPopular: Boolean,
    @SerializedName("sustainable")
    val sustainable: Boolean,
    @SerializedName("lowFodMap")
    val lowFodMap: Boolean,
    @SerializedName("weightWatcherSmartPoints")
    val weightWatcherSmartPoints: Int,
    @SerializedName("gaps")
    val gaps: String,
    @SerializedName("preparationMinutes")
    val preparationMinutes: Int,
    @SerializedName("cookingMinutes")
    val cookingMinutes: Int,
    @SerializedName("aggregateLikes")
    val aggregateLikes: Int,
    @SerializedName("healthScore")
    val healthScore: Int,
    @SerializedName("creditsText")
    val creditsText: String,
    @SerializedName("license")
    val license: String,
    @SerializedName("sourceName")
    val sourceName: String,
    @SerializedName("pricePerServing")
    val pricePerServing: Double,
    @SerializedName("extendedIngredients")
    val extendedIngredients: ArrayList<ExtendedIngredient>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("readyInMinutes")
    val readyInMinutes: Int,
    @SerializedName("servings")
    val servings: Int,
    @SerializedName("sourceUrl")
    val sourceUrl: String,
    @SerializedName("image")
    val image: String?,
    @SerializedName("imageType")
    val imageType: String,
    @SerializedName("summary")
    val summary: String,
    @SerializedName("cuisines")
    val cuisines: ArrayList<Any>,
    @SerializedName("dishTypes")
    val dishTypes: ArrayList<String>,
    @SerializedName("diets")
    val diets: ArrayList<String>,
    @SerializedName("occasions")
    val occasions: ArrayList<String>,
    @SerializedName("instructions")
    val instructions: String,
    @SerializedName("analyzedInstructions")
    val analyzedInstructions: ArrayList<AnalyzedInstruction>,
    @SerializedName("originalId")
    val originalId: Any,
    @SerializedName("spoonacularSourceUrl")
    val spoonacularSourceUrl: String
    )
