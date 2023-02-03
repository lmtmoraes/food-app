package com.example.food_app.ui.details

import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.food_app.R
import com.example.food_app.data.model.ExtendedIngredient
import com.example.food_app.databinding.FragmentDetailsBinding
import com.example.food_app.utils.Constants
import com.example.food_app.utils.Failed
import com.example.food_app.utils.Loading
import com.example.food_app.utils.Success
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailsFragment : Fragment() {

    private var binding: FragmentDetailsBinding? = null
    private var id: Int? = null
    private val viewModel: DetailsViewModel by viewModel()
    private val ingredientsAdapter by lazy { IngredientsAdapter() }
    private var apiKey = Constants.API_KEY

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.getString("id")?.let { id = it.toInt() }
        viewModel.getRecipeDetails(id!!, apiKey)
        setUpObserver()
    }

    private fun setUpObserver() {
        lifecycleScope.launchWhenCreated {
            viewModel.recipeDetailsLiveData.collect{
                when(it){
                    is Loading -> {
                        binding?.ingredientsTxt?.visibility = View.GONE
                    }
                    is Failed -> {
                        binding?.foodNameTxt?.visibility = View.GONE
                        binding?.ingredientsTxt?.visibility = View.GONE
                        binding?.rvIngredients?.visibility = View.GONE
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
                        binding?.ingredientsTxt?.visibility = View.VISIBLE
                        binding?.foodNameTxt?.text  = it.data?.title
                        val imageUrl = it.data?.image
                        if (imageUrl != null){
                            Picasso.get().load(imageUrl).into(binding?.foodImg)
                        } else{
                            binding?.foodImg?.setImageResource(R.drawable.ic_no_image)
                        }
                        binding?.foodDescription?.text = it.data?.summary
                        it.data?.extendedIngredients?.let { it1 -> initList(it1) }

                    }
                }
            }
        }
    }



    private fun initList(model: List<ExtendedIngredient>) {
        binding?.rvIngredients?.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = ingredientsAdapter
            ingredientsAdapter.setList(model)
        }
    }


}