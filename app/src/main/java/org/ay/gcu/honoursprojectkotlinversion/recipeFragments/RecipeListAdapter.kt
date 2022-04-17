package org.ay.gcu.honoursprojectkotlinversion.recipeFragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.custom_row_ingredient.view.*
import kotlinx.android.synthetic.main.recipe_custom_row.view.*
import org.ay.gcu.honoursprojectkotlinversion.R
import org.ay.gcu.honoursprojectkotlinversion.recipeModel.Recipe

class RecipeListAdapter: RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder>() {

    private var recipeList = emptyList<Recipe>()

    class RecipeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recipe_custom_row, parent, false))
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val currentRecipeItem = recipeList[position]
        holder.itemView.recipeIDtxt.text = currentRecipeItem.recipeid.toString()
        holder.itemView.recipeNametxt.text = currentRecipeItem.recipeName
       // holder.itemView.recipeIngtxt.text = currentRecipeItem.recipeIng
       // holder.itemView.recipeMethodtxt.text = currentRecipeItem.recipeMethod

        holder.itemView.recipeRowLayout.setOnClickListener{

            //Need to add the functonality to click the list item and open up more info

            val action =
               FourthFragmentDirections.actionFourthFragmentToViewRecipe(currentRecipeItem)
            holder.itemView.findNavController().navigate(action)
        }
    }
    fun setData(recipe: List<Recipe>){
        this.recipeList = recipe
        notifyDataSetChanged()
    }
}