package com.example.food_app.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.food_app.R
import com.example.food_app.data.model.Recipe
import com.example.food_app.databinding.FragmentMainBinding
import com.example.food_app.utils.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainFragment : Fragment() {

    private var binding: FragmentMainBinding? = null
    private val foodAdapter by lazy { RandomRecipesAdapter() }
    private val viewModel: RecipesViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        viewModel.getRandomRecipes(Constants.API_KEY, "10")
        setUpObserver()
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }


    private fun setUpObserver(){
        lifecycleScope.launchWhenCreated {
            viewModel.randomRecipesLiveData.collect{
                when (it){
                    is Loading -> {}
                    is Failed -> {
                        binding?.errorImg?.visibility = View.VISIBLE
                        binding?.errorTxt?.visibility = View.VISIBLE
                        if(it.message!! == "Sem conexão"){
                            binding?.errorImg?.setImageResource(R.drawable.ic_no_connection)
                            binding?.errorTxt?.text = getString(R.string.connection_error)
                        }
                        else{
                            binding?.errorImg?.setImageResource(R.drawable.ic_error)
                            binding?.errorTxt?.text = getString(R.string.error)
                        }
                    }
                    is Success -> {
                        it.data?.recipes?.let { it1 -> initList(it1) }
                    }
                }
            }
        }
    }


    private fun initList(model: List<Recipe>) {
        binding?.rvFood?.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = foodAdapter
            foodAdapter.setList(model)
        }
    }


}