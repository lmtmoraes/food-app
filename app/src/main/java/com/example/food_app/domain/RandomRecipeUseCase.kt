package com.example.food_app.domain

import com.example.food_app.data.repository.data_source.RandomRecipeRepository
import com.example.food_app.data.response.RandomRecipesResponse
import kotlinx.coroutines.flow.Flow

class RandomRecipeUseCase(private val randomRecipeRepository: RandomRecipeRepository) {

    suspend fun executeGetRandomRecipes(apiKey: String, number: String) : Flow<RandomRecipesResponse> {
        return randomRecipeRepository.getRandomRecipes(apiKey, number)
    }

}