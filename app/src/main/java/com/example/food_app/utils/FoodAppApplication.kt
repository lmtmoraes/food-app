package com.example.food_app.utils

import android.app.Application
import com.example.food_app.data.di.listModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class FoodAppApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@FoodAppApplication)
            modules(listModules)
        }
    }


}
