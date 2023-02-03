package com.example.food_app.data.model

import com.google.gson.annotations.SerializedName

data class WineParing(
    @SerializedName("pairedWines")
    val pairedWines: ArrayList<String>,
    @SerializedName("pairingText")
    val pairingText: String,
    @SerializedName("productMatches")
    val productMatches: ArrayList<ProductMatch>
)
