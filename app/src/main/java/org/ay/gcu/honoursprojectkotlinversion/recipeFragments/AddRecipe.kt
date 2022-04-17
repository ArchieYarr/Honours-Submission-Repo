package org.ay.gcu.honoursprojectkotlinversion.recipeFragments

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_add_ingredient.*
import kotlinx.android.synthetic.main.fragment_add_ingredient.view.*
import kotlinx.android.synthetic.main.fragment_add_recipe.*
import kotlinx.android.synthetic.main.fragment_add_recipe.view.*
import org.ay.gcu.honoursprojectkotlinversion.IngredientsModel.Ingredient
import org.ay.gcu.honoursprojectkotlinversion.R
import org.ay.gcu.honoursprojectkotlinversion.ingredientViewModel.IngredientViewModel
import org.ay.gcu.honoursprojectkotlinversion.recipeModel.Recipe
import org.ay.gcu.honoursprojectkotlinversion.recipeViewModel.RecipeViewModel

class AddRecipe : Fragment() {

    private lateinit var recipeViewModel : RecipeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_recipe, container, false)

        recipeViewModel = ViewModelProvider(this).get(RecipeViewModel::class.java)

        view.addRecipe_button.setOnClickListener {
            insertDataToDatabase()
        }
        return view
    }
    private fun insertDataToDatabase(){
        val recipeName = addRecipeName.text.toString()
        val recipeIngredient = addRecipeIngredients.text.toString()
        val recipeMethods = addRecipeMethod.text.toString()

        if(inputCheck(recipeName,recipeIngredient,recipeMethods)){
            //create ingredient object
            val recipe = Recipe(0, recipeName, recipeIngredient, recipeMethods)
            //add the data to the database
            recipeViewModel.addRecipe(recipe)
            Toast.makeText(requireContext(), "successfully added recipe!", Toast.LENGTH_LONG).show()
            //Navigate back to the ingredients page
            findNavController().navigate(R.id.action_addRecipe_to_fourthFragment)
        }else{
            Toast.makeText(requireContext(), "Please fill out all of the recipe information", Toast.LENGTH_LONG).show()
        }
    }
    private fun inputCheck(recipeName: String, recipeIngredient: String, recipeMethod: String): Boolean{
        return !(TextUtils.isEmpty(recipeName) && TextUtils.isEmpty(recipeIngredient) && recipeMethod.isEmpty())
    }
}