package com.example.food_app.data.service

import com.example.food_app.data.response.RecipeDetailsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeDetailsService {
    @GET("recipes/{id}/information")
    suspend fun getRecipeDetails(@Path("id") id: Int, @Query("apiKey") apiKey: String) : RecipeDetailsResponse
}