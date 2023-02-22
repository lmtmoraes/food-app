package com.example.food_app.ui.details

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.food_app.data.model.Step
import com.example.food_app.databinding.ItemStepsBinding

class StepsAdapter(private val data: List<Step>) : RecyclerView.Adapter<StepsAdapter.ViewHolder>() {


    private lateinit var binding: ItemStepsBinding

    inner class ViewHolder(binding: ItemStepsBinding) : RecyclerView.ViewHolder(binding.root){
        @SuppressLint("SetTextI18n")
        fun bind(item: Step){
            binding.stepNumberTxt.text = item.number + " - "
            binding.stepTxt.text = item.step
            if(item.ingredients.isEmpty()){
                binding.ingredientsTxt.visibility = View.INVISIBLE
            }
            binding.rvIngredients.apply {
                layoutManager = object : LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false){
                    override fun canScrollVertically(): Boolean {
                        return false
                    }
                }
                adapter = StepIngredientsAdapter(item.ingredients)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemStepsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return data.size
    }


}