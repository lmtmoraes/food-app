package com.example.food_app.data.repository.data_impl

import com.example.food_app.data.repository.data_source.InstructionsRepository
import com.example.food_app.data.response.InstructionsResponse
import com.example.food_app.data.service.InstructionsService
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class InstructionsRepositoryImpl(private val instructionsService: InstructionsService) : InstructionsRepository {


    override suspend fun getInstructions(
        id: Int,
        apiKey: String
    ) = flow {
        coroutineScope {
            val response = instructionsService.getInstructions(id, apiKey)
            emit(response)
        }
    }

}