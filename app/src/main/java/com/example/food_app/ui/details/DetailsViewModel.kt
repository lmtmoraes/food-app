package com.example.food_app.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.food_app.data.response.RecipeDetailsResponse
import com.example.food_app.domain.RecipeDetailsUseCase
import com.example.food_app.utils.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class DetailsViewModel(private val recipeDetailsUseCase: RecipeDetailsUseCase) : ViewModel() {

    private val _recipeDetailsLiveData = MutableStateFlow<Resource<RecipeDetailsResponse>>(Loading())
    val recipeDetailsLiveData: StateFlow<Resource<RecipeDetailsResponse>>
        get() = _recipeDetailsLiveData

    fun getRecipeDetails(id: Int, apiKey: String){
        viewModelScope.launch {
            recipeDetailsUseCase.executeGetRecipeDetails(id, apiKey)
                .onStart {
                    _recipeDetailsLiveData.value = Loading()
                }
                .catch { error ->
                    _recipeDetailsLiveData.value = Failed(error.errorApi())
                }
                .collect{
                    _recipeDetailsLiveData.value = Success(it)
                }
        }
    }
}