package com.example.food_app.data.repository.data_source

import com.example.food_app.data.response.InstructionsResponse
import kotlinx.coroutines.flow.Flow


interface InstructionsRepository {

    suspend fun getInstructions(id: Int, apiKey: String) : Flow<List<InstructionsResponse>>

}