package com.example.food_app.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.food_app.R
import com.example.food_app.data.model.Recipe
import com.example.food_app.databinding.ItemMenuBinding
import com.example.food_app.utils.OnItemClickListener
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
            binding.randomListCard.setOnClickListener { onItemClickListener?.onClick(item.id.toString()) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mList[position])
        val imageUrl = mList[position].image
        if(imageUrl != null){
            Picasso.get().load(imageUrl).into(holder.itemView.findViewById<ImageView>(R.id.food_img))
        } else {
            holder.itemView.findViewById<ImageView>(R.id.food_img).visibility = View.GONE
            holder.itemView.findViewById<ImageView>(R.id.no_img).visibility = View.VISIBLE
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(data: List<Recipe>){
        mList.clear()
        mList.addAll(data)
        notifyDataSetChanged()
    }

    private var onItemClickListener: OnItemClickListener? = null

    fun addOnItemClickListener(onItemClickListener: OnItemClickListener){
        this.onItemClickListener = onItemClickListener
    }




}