package com.example.food_app.data

import com.example.food_app.utils.Constants
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {



    private val apiClient = OkHttpClient().newBuilder()
        .build()


    private var gson = GsonBuilder()
        .setLenient()
        .create()


    private fun retrofit(): Retrofit = Retrofit.Builder()
        .client(apiClient)
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    fun <T> create(serviceClass: Class<T>): T{
        return retrofit().create(serviceClass)
    }

}