package com.example.food_app.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.food_app.R
import com.example.food_app.data.model.FoodResponse
import com.example.food_app.data.response.RandomRecipesResponse
import com.example.food_app.domain.RandomRecipeUseCase
import com.example.food_app.utils.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class RecipesViewModel(private val randomRecipeUseCase: RandomRecipeUseCase) : ViewModel() {


    private val _randomRecipesLiveData = MutableStateFlow<Resource<RandomRecipesResponse>>(Loading())
    val randomRecipesLiveData: StateFlow<Resource<RandomRecipesResponse>>
        get() = _randomRecipesLiveData


    fun getRandomRecipes(apiKey: String, number: String, tags: List<String>){
        viewModelScope.launch {
            randomRecipeUseCase.executeGetRandomRecipes(apiKey, number, tags)
                .onStart {
                    _randomRecipesLiveData.value = Loading()
                }
                .catch { error ->
                    _randomRecipesLiveData.value = Failed(error.errorApi())
                }
                .collect{
                    _randomRecipesLiveData.value = Success(it)
                }
        }
    }

}