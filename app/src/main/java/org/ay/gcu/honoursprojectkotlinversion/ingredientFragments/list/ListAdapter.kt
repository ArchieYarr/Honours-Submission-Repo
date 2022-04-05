package org.ay.gcu.honoursprojectkotlinversion.ingredientFragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.custom_row_ingredient.view.*
import org.ay.gcu.honoursprojectkotlinversion.R
import org.ay.gcu.honoursprojectkotlinversion.IngredientsModel.Ingredient

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var ingredientList = emptyList<Ingredient>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row_ingredient, parent, false))
    }

    override fun getItemCount(): Int {
        return ingredientList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = ingredientList[position]
        holder.itemView.ingredientIDtxt.text = currentItem.id.toString()
        holder.itemView.ingredientNametxt.text = currentItem.ingredientName
        holder.itemView.ingredientCattxt.text = currentItem.ingredientCategory
        holder.itemView.ingredientQuanttxt.text = currentItem.ingredientQuantity.toString()

        holder.itemView.rowLayout.setOnClickListener{

            val action =
                SecondFragmentDirections.actionSecondFragmentToUpdateIngredientFragment(currentItem)
             holder.itemView.findNavController().navigate(action)
        }
    }
    fun setData(ingredient: List<Ingredient>){
        this.ingredientList = ingredient
        notifyDataSetChanged()
    }
}