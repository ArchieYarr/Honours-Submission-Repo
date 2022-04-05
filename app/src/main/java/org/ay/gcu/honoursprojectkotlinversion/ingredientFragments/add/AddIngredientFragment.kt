package org.ay.gcu.honoursprojectkotlinversion.ingredientFragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_add_ingredient.*
import kotlinx.android.synthetic.main.fragment_add_ingredient.view.*
import org.ay.gcu.honoursprojectkotlinversion.R
import org.ay.gcu.honoursprojectkotlinversion.IngredientsModel.Ingredient
import org.ay.gcu.honoursprojectkotlinversion.ingredientViewModel.IngredientViewModel


class AddIngredientFragment : Fragment() {

private lateinit var ingredientViewModel : IngredientViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_ingredient, container, false)

        ingredientViewModel = ViewModelProvider(this).get(IngredientViewModel::class.java)

        view.add_button.setOnClickListener {
            insertDataToDatabase()
        }
        return view
    }
    private fun insertDataToDatabase(){
        val ingredientName = addIngredientName_et.text.toString()
        val ingredientCategory = addIngredientCategory_et.text.toString()
        val ingredientQuantity = addIngredientQuantity_et.text

        if(inputCheck(ingredientName,ingredientCategory,ingredientQuantity)){
            //create ingredient object
            val ingredient = Ingredient(0, ingredientName, ingredientCategory, Integer.parseInt(ingredientQuantity.toString()))
            //add the data to the database
            ingredientViewModel.addIngredient(ingredient)
            Toast.makeText(requireContext(), "successfully added!", Toast.LENGTH_LONG).show()
            //Navigate back to the ingredients page
            findNavController().navigate(R.id.action_addIngredientFragment_to_secondFragment)
        }else{
            Toast.makeText(requireContext(), "Please fill out all of the ingredient information", Toast.LENGTH_LONG).show()
        }
    }
    private fun inputCheck(ingredientName: String, ingredientCategory: String, ingredientQuantity: Editable): Boolean{
        return !(TextUtils.isEmpty(ingredientName) && TextUtils.isEmpty(ingredientCategory) && ingredientQuantity.isEmpty())
    }
}