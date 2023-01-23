package com.example.food_app.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.food_app.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private var binding: FragmentMainBinding? = null
    private val foodAdapter by lazy { FoodAdapter() }
    private lateinit var viewModel: FoodViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(requireActivity())[FoodViewModel::class.java]
        initList()
    }

    private fun initList() {
        binding?.rvFood?.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = foodAdapter
            foodAdapter.setList(viewModel.listFood())
        }
    }


}