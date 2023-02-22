package com.example.food_app.ui.details

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.food_app.R
import com.example.food_app.data.response.InstructionsResponse
import com.example.food_app.databinding.ItemInstructionsBinding
import com.google.android.material.card.MaterialCardView

class InstructionsAdapter(val context: Context) : RecyclerView.Adapter<InstructionsAdapter.ViewHolder>() {


    private val mList = mutableListOf<InstructionsResponse>()
    private lateinit var binding: ItemInstructionsBinding

    inner class ViewHolder(binding: ItemInstructionsBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: InstructionsResponse){
            binding.instructionsTxt.text = item.name
            binding.rvSteps.apply {
                layoutManager = object : LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false){
                    override fun canScrollVertically(): Boolean {
                        return false
                    }
                }
                adapter = StepsAdapter(item.steps)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemInstructionsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    fun setList(data: List<InstructionsResponse>){
        mList.clear()
        mList.addAll(data)
        notifyDataSetChanged()
    }


}