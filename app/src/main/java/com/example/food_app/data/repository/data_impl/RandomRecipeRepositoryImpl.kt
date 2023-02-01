package com.example.food_app.data.repository.data_impl

import com.example.food_app.data.repository.data_source.RandomRecipeRepository
import com.example.food_app.data.response.RandomRecipesResponse
import com.example.food_app.data.service.RandomRecipeService
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RandomRecipeRepositoryImpl(private val randomRecipeService: RandomRecipeService) : RandomRecipeRepository {

    override suspend fun getRandomRecipes(
        apiKey: String,
        number: String,
        tags: List<String>
    ) = flow {
        coroutineScope {
            val response = randomRecipeService.getRandomRecipes(apiKey, number, tags)
            emit(response)
        }
    }
}