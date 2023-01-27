package com.example.food_app.utils

import android.view.View
import android.widget.Toast

fun View.makeToast(message: String){
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}