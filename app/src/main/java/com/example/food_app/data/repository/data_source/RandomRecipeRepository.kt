package com.example.food_app.data.repository.data_source

import com.example.food_app.data.response.RandomRecipesResponse
import kotlinx.coroutines.flow.Flow

interface RandomRecipeRepository {

    suspend fun getRandomRecipes(apiKey: String, number: String) : Flow<RandomRecipesResponse>


}