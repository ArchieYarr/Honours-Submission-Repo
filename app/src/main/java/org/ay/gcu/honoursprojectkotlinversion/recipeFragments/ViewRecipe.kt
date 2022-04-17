package org.ay.gcu.honoursprojectkotlinversion.recipeFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_update_ingredient.view.*
import kotlinx.android.synthetic.main.fragment_view_recipe.view.*
import org.ay.gcu.honoursprojectkotlinversion.R

import org.ay.gcu.honoursprojectkotlinversion.recipeViewModel.RecipeViewModel

class ViewRecipe : Fragment() {

    private val args by navArgs<ViewRecipeArgs>()


    private lateinit var recipeViewModel: RecipeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view_recipe, container, false)

        recipeViewModel = ViewModelProvider(this).get(RecipeViewModel::class.java)

        view.ViewRecipeName.setText(args.currentRecipeItem.recipeName)
        view.ViewRecipeIngredients.setText(args.currentRecipeItem.recipeIng)
        view.ViewRecipeMethod.setText(args.currentRecipeItem.recipeMethod)

        view.backButton.setOnClickListener{

            findNavController().navigate(R.id.action_viewRecipe_to_fourthFragment)

        }
        //add (delete)Menu to the option bar
        setHasOptionsMenu(true)

        return view












    }
}