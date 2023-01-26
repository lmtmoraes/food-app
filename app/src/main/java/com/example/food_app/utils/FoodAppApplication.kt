package com.example.food_app.utils

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.example.food_app.data.di.listModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class FoodAppApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        instance = applicationContext
        startKoin {
            androidContext(this@FoodAppApplication)
            modules(listModules)
        }
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        var instance: Context? = null
            private set
    }
}
