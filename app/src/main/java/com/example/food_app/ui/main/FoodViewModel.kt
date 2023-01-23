package com.example.food_app.ui.main

import androidx.lifecycle.ViewModel
import com.example.food_app.R
import com.example.food_app.data.model.FoodResponse

class FoodViewModel : ViewModel() {

    fun listFood() : MutableList<FoodResponse>{

        val list = mutableListOf<FoodResponse>()

        list.add(FoodResponse(R.drawable.salad, "Salada", "35 servings", "12 likes", "60 minutes"))
        list.add(FoodResponse(R.drawable.salad, "Salada", "35 servings", "12 likes", "60 minutes"))
        list.add(FoodResponse(R.drawable.salad, "Salada", "35 servings", "12 likes", "60 minutes"))
        list.add(FoodResponse(R.drawable.salad, "Salada", "35 servings", "12 likes", "60 minutes"))
        list.add(FoodResponse(R.drawable.salad, "Salada", "35 servings", "12 likes", "60 minutes"))
        list.add(FoodResponse(R.drawable.salad, "Salada", "35 servings", "12 likes", "60 minutes"))
        list.add(FoodResponse(R.drawable.salad, "Salada", "35 servings", "12 likes", "60 minutes"))
        list.add(FoodResponse(R.drawable.salad, "Salada", "35 servings", "12 likes", "60 minutes"))
        list.add(FoodResponse(R.drawable.salad, "Salada", "35 servings", "12 likes", "60 minutes"))
        list.add(FoodResponse(R.drawable.salad, "Salada", "35 servings", "12 likes", "60 minutes"))

        return list

    }

}