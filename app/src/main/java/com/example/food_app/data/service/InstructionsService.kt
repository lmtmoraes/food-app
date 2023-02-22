package com.example.food_app.data.service

import com.example.food_app.data.response.InstructionsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface InstructionsService {
    @GET("/recipes/{id}/analyzedInstructions")
    suspend fun getInstructions(@Path("id") id: Int, @Query("apiKey") apiKey: String) : List<InstructionsResponse>
}