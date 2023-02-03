package com.example.food_app.domain

import com.example.food_app.data.repository.data_source.RecipeDetailsRepository
import com.example.food_app.data.response.RecipeDetailsResponse
import kotlinx.coroutines.flow.Flow

class RecipeDetailsUseCase(private val recipeDetailsRepository: RecipeDetailsRepository) {

    suspend fun executeGetRecipeDetails(id: Int, apiKey: String) : Flow<RecipeDetailsResponse>{
        return recipeDetailsRepository.getRecipeDetails(id, apiKey)
    }

}