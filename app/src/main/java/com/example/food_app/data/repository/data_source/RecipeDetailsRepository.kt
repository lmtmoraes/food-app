package com.example.food_app.data.repository.data_source

import com.example.food_app.data.response.RecipeDetailsResponse
import kotlinx.coroutines.flow.Flow

interface RecipeDetailsRepository {

    suspend fun getRecipeDetails(id: Int, apiKey: String) : Flow<RecipeDetailsResponse>

}