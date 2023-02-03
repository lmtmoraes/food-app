package com.example.food_app.ui.main


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
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
    private var tagsList = ArrayList<String>()
    private var apiKey = Constants.API_KEY
    private var number = "20"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        viewModel.getRandomRecipes(apiKey, number, tagsList)
        setUpObserver()
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        textListener(binding?.editSearch!!)
        setSpinner()
    }

    private fun setSpinner() {
        val spinner = binding?.tagSpinner
        val arrayAdapter = ArrayAdapter.createFromResource(requireContext(),
            R.array.tags,
            R.layout.spinner_text
            )
        arrayAdapter.setDropDownViewResource(R.layout.spinner_inner_text)
        spinner?.adapter = arrayAdapter
        spinnerListener(spinner!!)
    }

    private fun setUpObserver(){
        lifecycleScope.launchWhenCreated {
            viewModel.randomRecipesLiveData.collect{
                when (it){
                    is Loading -> {
                        binding?.progressBar?.visibility = View.VISIBLE
                    }
                    is Failed -> {
                        binding?.progressBar?.visibility = View.GONE
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
                        binding?.progressBar?.visibility = View.GONE
                        it.data?.recipes?.let { it1 -> initList(it1) }
                    }
                }
            }
        }
    }

    private fun textListener(editText: SearchView){
        editText.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                tagsList.clear()
                tagsList.add(query!!)
                viewModel.getRandomRecipes(apiKey, number, tagsList)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }


    private fun spinnerListener(spinner: Spinner){
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                tagsList.clear()
                tagsList.add(spinner.selectedItem.toString())
                viewModel.getRandomRecipes(Constants.API_KEY, "20", tagsList)
                setUpObserver()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }
    }

    private fun initList(model: List<Recipe>) {
        binding?.rvFood?.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = foodAdapter
            foodAdapter.setList(model)
            foodAdapter.addOnItemClickListener(object : OnItemClickListener {
                override fun onClick(id: String) {
                    val op = Bundle()
                    op.putString("id", id)
                    findNavController().navigate(R.id.detailsFragment, op)
                }
            })
        }
    }


}