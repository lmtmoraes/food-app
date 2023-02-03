package com.example.food_app.data.di

import com.example.food_app.data.ApiFactory

import com.example.food_app.data.repository.data_impl.RandomRecipeRepositoryImpl
import com.example.food_app.data.repository.data_impl.RecipeDetailsRepositoryImpl
import com.example.food_app.data.repository.data_source.RandomRecipeRepository
import com.example.food_app.data.repository.data_source.RecipeDetailsRepository
import com.example.food_app.data.service.RandomRecipeService
import com.example.food_app.data.service.RecipeDetailsService
import com.example.food_app.domain.RandomRecipeUseCase
import com.example.food_app.domain.RecipeDetailsUseCase
import com.example.food_app.ui.details.DetailsViewModel
import com.example.food_app.ui.main.RecipesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module{
    viewModel{
        RecipesViewModel(randomRecipeUseCase = get())
    }
    viewModel{
        DetailsViewModel(recipeDetailsUseCase = get())
    }
}

val repositoryModule = module{
    single<RandomRecipeRepository>{
        RandomRecipeRepositoryImpl(randomRecipeService = get())
    }
    single<RecipeDetailsRepository>{
        RecipeDetailsRepositoryImpl(recipeDetailsService = get())
    }
}

val useCase = module {
    single {
        RandomRecipeUseCase(randomRecipeRepository = get())
    }
    single {
        RecipeDetailsUseCase(recipeDetailsRepository = get())
    }
}

val serviceModule = module {
    single {
        ApiFactory.create(RandomRecipeService::class.java)
    }
    single {
        ApiFactory.create(RecipeDetailsService::class.java)
    }
}

val listModules = listOf(viewModelModule, repositoryModule, useCase, serviceModule)