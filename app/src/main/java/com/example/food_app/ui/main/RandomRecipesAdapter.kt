package com.example.food_app.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.food_app.data.model.FoodResponse
import com.example.food_app.data.model.Recipe
import com.example.food_app.data.response.RandomRecipesResponse
import com.example.food_app.databinding.ItemMenuBinding
import com.squareup.picasso.Picasso

class RandomRecipesAdapter() : RecyclerView.Adapter<RandomRecipesAdapter.ViewHolder>() {

    private val mList = mutableListOf<Recipe>()
    private lateinit var binding: ItemMenuBinding

    inner class ViewHolder(binding: ItemMenuBinding) : RecyclerView.ViewHolder(binding.root){
        @SuppressLint("SetTextI18n")
        fun bind(item: Recipe){
            binding.foodNameTxt.text = item.title
            binding.servingTxt.text = item.servings.toString() + " Servings"
            binding.likesTxt.text = item.aggregateLikes.toString() + " Likes"
            binding.timeTxt.text = item.preparationMinutes.toString() + " Minutes"
            binding.foodNameTxt.isSelected = true
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mList[position])
        Picasso.get().load(mList[position].image).into(binding.foodImg)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    fun setList(data: List<Recipe>){
        mList.clear()
        mList.addAll(data)
        notifyDataSetChanged()
    }


}