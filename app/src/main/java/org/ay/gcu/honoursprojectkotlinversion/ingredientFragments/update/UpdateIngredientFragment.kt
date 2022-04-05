package org.ay.gcu.honoursprojectkotlinversion.ingredientFragments.update

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_update_ingredient.*
import kotlinx.android.synthetic.main.fragment_update_ingredient.view.*
import org.ay.gcu.honoursprojectkotlinversion.ingredientViewModel.IngredientViewModel
import org.ay.gcu.honoursprojectkotlinversion.IngredientsModel.Ingredient
import org.ay.gcu.honoursprojectkotlinversion.R


class UpdateIngredientFragment : Fragment() {

    private val args by navArgs<UpdateIngredientFragmentArgs>()


    private lateinit var ingredientViewModel: IngredientViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update_ingredient, container, false)

        ingredientViewModel = ViewModelProvider(this).get(IngredientViewModel::class.java)

        view.updateIngredientName_et.setText(args.currentItem.ingredientName)
        view.updateIngredientCategory_et.setText(args.currentItem.ingredientCategory)
        view.updateIngredientQuantity_et.setText(args.currentItem.ingredientQuantity.toString())

        view.update_button.setOnClickListener{
            updateItem()

        }
        //add (delete)Menu to the option bar
        setHasOptionsMenu(true)

        return view
    }
    private fun updateItem() {
        val ingredientName = updateIngredientName_et.text.toString()
        val ingredientCategory = updateIngredientCategory_et.text.toString()
        val ingredientQuantity = Integer.parseInt(updateIngredientQuantity_et.text.toString())

        if (inputCheck(ingredientName, ingredientCategory, updateIngredientQuantity_et.text)){
            //call method to create Ingredient Object
            val updatedIngredient = Ingredient(args.currentItem.id, ingredientName, ingredientCategory, ingredientQuantity)
            //call update function for room database
            ingredientViewModel.updateIngredient(updatedIngredient)
            Toast.makeText(requireContext(), "Updated Ingredient Successfully!",Toast.LENGTH_SHORT).show()
            //navigate back to fragment 2
            findNavController().navigate(R.id.action_updateIngredientFragment_to_secondFragment)
        }else
            Toast.makeText(requireContext(), "Please fill out all fields!",Toast.LENGTH_SHORT).show()


    }
        private fun inputCheck(ingredientName: String, ingredientCategory: String, ingredientQuantity: Editable): Boolean{
            return !(TextUtils.isEmpty(ingredientName) && TextUtils.isEmpty(ingredientCategory) && ingredientQuantity.isEmpty())
        }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater){
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_delete){
            deleteIngredient()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteIngredient(){
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton( "Yes"){_,_->
            ingredientViewModel.deleteIngredient(args.currentItem)
            Toast.makeText(requireContext(),
                "Successfully removed: ${args.currentItem.ingredientName}",
                Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateIngredientFragment_to_secondFragment)
        }
        builder.setNegativeButton("No"){_,_->}
        builder.setTitle("Delete${args.currentItem.ingredientName}?")
        builder.setMessage("Are you sure you want to delete ${args.currentItem.ingredientName}")
        builder.create().show()
    }
}