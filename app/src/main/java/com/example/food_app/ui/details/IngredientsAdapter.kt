package com.example.food_app.ui.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.food_app.data.model.ExtendedIngredient
import com.example.food_app.databinding.ItemIngredientBinding
import com.squareup.picasso.Picasso


class IngredientsAdapter() : RecyclerView.Adapter<IngredientsAdapter.ViewHolder>() {

    private val mList = mutableListOf<ExtendedIngredient>()
    private lateinit var binding: ItemIngredientBinding

    inner class ViewHolder(binding: ItemIngredientBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: ExtendedIngredient){
            binding.ingredientQuantity.text = item.original
            binding.ingredientQuantity.isSelected = true
            binding.ingredientName.text = item.name
            binding.ingredientName.isSelected = true
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemIngredientBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mList[position])
        Picasso.get().load("https://spoonacular.com/cdn/ingredients_100x100/" + mList[position].image).into(binding.ingredientImg)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    fun setList(data: List<ExtendedIngredient>){
        mList.clear()
        mList.addAll(data)
        notifyDataSetChanged()
    }

}