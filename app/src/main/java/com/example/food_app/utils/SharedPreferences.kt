package com.example.food_app.utils

import android.annotation.SuppressLint
import android.content.Context

class SharedPreferences(val context: Context) {

    private val sessionPreferences: android.content.SharedPreferences = context.getSharedPreferences("app", Context.MODE_PRIVATE)

    fun getValueInSharedPreferences(key: String): String{
        return sessionPreferences.getString(key, "") ?: ""
    }


    companion object {

        @SuppressLint("StaticFieldLeak")
        private var mInstance: SharedPreferences? = null

        fun getInstance(context: Context): SharedPreferences {
            if(mInstance == null)
                mInstance = SharedPreferences(context)
            return mInstance as SharedPreferences
        }

    }


}