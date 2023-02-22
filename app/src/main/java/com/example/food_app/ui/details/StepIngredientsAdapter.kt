package com.example.food_app.ui.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.food_app.data.model.Ingredient
import com.example.food_app.databinding.ItemStepViewsBinding
import com.squareup.picasso.Picasso

class StepIngredientsAdapter(private val data: List<Ingredient>)  : RecyclerView.Adapter<StepIngredientsAdapter.ViewHolder>() {

    private lateinit var binding: ItemStepViewsBinding

    inner class ViewHolder(binding: ItemStepViewsBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: Ingredient){
            binding.itemName.text = item.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemStepViewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
        Picasso.get().load("https://spoonacular.com/cdn/ingredients_100x100/" + data[position].image).into(binding.itemImg)
    }

    override fun getItemCount(): Int {
        return data.size
    }



}