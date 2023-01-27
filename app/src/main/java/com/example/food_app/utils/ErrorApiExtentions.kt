package com.example.food_app.utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.HttpException

fun Throwable.errorApi(): String{
    val message = (this as? HttpException) ?: return "Sem conexão"
    val type = object : TypeToken<ErrorModel>() {}.type
    val errorModel: ErrorModel? = Gson().fromJson(message.response()?.errorBody()?.charStream(), type)
    val errorMessage = errorModel?.let {
        it.error.toString()
    }
    return errorMessage!!
}