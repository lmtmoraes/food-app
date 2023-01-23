package com.example.food_app.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.food_app.data.model.FoodResponse
import com.example.food_app.databinding.ItemMenuBinding

class FoodAdapter() : RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    private val mList = mutableListOf<FoodResponse>()
    private lateinit var binding: ItemMenuBinding

    inner class ViewHolder(binding: ItemMenuBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: FoodResponse){
            binding.foodImg.setImageResource(item.foodImg)
            binding.foodNameTxt.text = item.foodName
            binding.servingTxt.text = item.serving
            binding.likesTxt.text = item.likes
            binding.timeTxt.text = item.time
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    fun setList(data: List<FoodResponse>){
        mList.clear()
        mList.addAll(data)
        notifyDataSetChanged()
    }


}