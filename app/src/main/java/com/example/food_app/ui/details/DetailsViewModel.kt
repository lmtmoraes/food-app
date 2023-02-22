package com.example.food_app.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.food_app.data.response.InstructionsResponse

import com.example.food_app.data.response.RecipeDetailsResponse
import com.example.food_app.domain.InstructionsUseCase
import com.example.food_app.domain.RecipeDetailsUseCase
import com.example.food_app.utils.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class DetailsViewModel(private val recipeDetailsUseCase: RecipeDetailsUseCase,
                       private val instructionsUseCase: InstructionsUseCase) : ViewModel() {

    private val _recipeDetailsLiveData = MutableStateFlow<Resource<RecipeDetailsResponse>>(Loading())
    val recipeDetailsLiveData: StateFlow<Resource<RecipeDetailsResponse>>
        get() = _recipeDetailsLiveData

    private val _instructionsLiveData = MutableStateFlow<Resource<List<InstructionsResponse>>>(Loading())
    val instructionsLiveData: StateFlow<Resource<List<InstructionsResponse>>>
        get() = _instructionsLiveData

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


    fun getInstructions(id: Int, apiKey: String){
        viewModelScope.launch {
            instructionsUseCase.executeGetInstructions(id, apiKey)
                .onStart {
                    _instructionsLiveData.value = Loading()
                }
                .catch { error ->
                    _instructionsLiveData.value = Failed(error.errorApi())
                }
                .collect{
                    _instructionsLiveData.value = Success(it)
                }
        }
    }


}