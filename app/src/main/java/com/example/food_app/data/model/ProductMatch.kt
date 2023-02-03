package com.example.food_app.data.model

import com.google.gson.annotations.SerializedName

data class ProductMatch(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("averageRating")
    val averageRating: Double,
    @SerializedName("ratingCount")
    val ratingCount: Double,
    @SerializedName("score")
    val score: Double,
    @SerializedName("link")
    val link: String
)
