package com.example.food_app.domain

import com.example.food_app.data.repository.data_source.InstructionsRepository
import com.example.food_app.data.response.InstructionsResponse
import kotlinx.coroutines.flow.Flow


class InstructionsUseCase(private val instructionsRepository: InstructionsRepository) {

    suspend fun executeGetInstructions(id: Int, apiKey: String) : Flow<List<InstructionsResponse>> {
        return  instructionsRepository.getInstructions(id, apiKey)
    }

}