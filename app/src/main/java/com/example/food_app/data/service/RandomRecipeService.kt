package com.example.food_app.data.service

import com.example.food_app.data.response.RandomRecipesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RandomRecipeService {

    @GET("recipes/random")
    suspend fun getRandomRecipes(@Query("apiKey") apiKey: String, @Query("number") number: String, @Query("tags") tags: List<String>) : RandomRecipesResponse


}