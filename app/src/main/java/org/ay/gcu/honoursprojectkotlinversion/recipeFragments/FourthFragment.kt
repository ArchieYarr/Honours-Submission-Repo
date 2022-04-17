package org.ay.gcu.honoursprojectkotlinversion.recipeFragments

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_fourth.view.*

import org.ay.gcu.honoursprojectkotlinversion.R
import org.ay.gcu.honoursprojectkotlinversion.ingredientFragments.list.ListAdapter
import org.ay.gcu.honoursprojectkotlinversion.recipeViewModel.RecipeViewModel


class FourthFragment : Fragment() {

    private lateinit var recipeViewModel: RecipeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_fourth, container, false)

        //recyclerviewRecipe
        val recipeAdapter = RecipeListAdapter()
        val recyclerView = view.recipeRecyclerview
        recyclerView.adapter = recipeAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())


        //recipeViewModel
        recipeViewModel = ViewModelProvider(this).get(RecipeViewModel::class.java)
        recipeViewModel.readAll.observe(viewLifecycleOwner, Observer{ recipe -> recipeAdapter.setData(recipe) })

        view.floatingRecipeActionButton.setOnClickListener(){
            findNavController().navigate(R.id.action_fourthFragment_to_addRecipe)
        }

        setHasOptionsMenu(true)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater){
        //inflater.inflate(R.menu.delete_menu, menu)
        inflater.inflate(R.menu.delete_menu, menu)





    }








}