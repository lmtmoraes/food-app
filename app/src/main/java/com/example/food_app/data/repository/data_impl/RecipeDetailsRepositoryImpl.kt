package com.example.food_app.data.repository.data_impl

import com.example.food_app.data.repository.data_source.RecipeDetailsRepository
import com.example.food_app.data.response.RecipeDetailsResponse
import com.example.food_app.data.service.RecipeDetailsService
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RecipeDetailsRepositoryImpl(private val recipeDetailsService: RecipeDetailsService) : RecipeDetailsRepository{

    override suspend fun getRecipeDetails(
        id: Int,
        apiKey: String
    ) = flow {
        coroutineScope {
            val response = recipeDetailsService.getRecipeDetails(id, apiKey)
            emit(response)
        }
    }

}