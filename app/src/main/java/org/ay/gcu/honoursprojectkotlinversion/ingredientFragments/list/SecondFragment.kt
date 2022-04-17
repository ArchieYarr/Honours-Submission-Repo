package org.ay.gcu.honoursprojectkotlinversion.ingredientFragments.list

import android.app.AlertDialog
import android.os.Bundle

import android.view.*
import android.view.Menu
import android.view.MenuItem

import android.widget.Toast

import androidx.fragment.app.Fragment

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_second.view.*
import org.ay.gcu.honoursprojectkotlinversion.R
import org.ay.gcu.honoursprojectkotlinversion.ingredientViewModel.IngredientViewModel


class SecondFragment : Fragment() {




   private lateinit var ingredientViewModel: IngredientViewModel

   override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_second, container, false)
        //Recycler View (display users input ingredients)
        val adapter = ListAdapter()
        val recyclerView = view.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        //IngredientViewModel
        ingredientViewModel = ViewModelProvider(this).get(IngredientViewModel::class.java)
        ingredientViewModel.readAlldata.observe(viewLifecycleOwner, Observer{ ingredient ->
            adapter.setData(ingredient)
        })



        view.floatingActionButton.setOnClickListener(){
            findNavController().navigate(R.id.action_secondFragment_to_addIngredientFragment)
        }

        //add (delete)Menu to the option bar
        setHasOptionsMenu(true)

        return view
    }

      override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        inflater.inflate(R.menu.delete_menu, menu)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean{
            if(item.itemId == R.id.menu_delete){
            deleteAllIngredients()
        }
            return super.onOptionsItemSelected(item)

    }

    private fun deleteAllIngredients() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton( "Yes"){_,_->
            ingredientViewModel.deleteAllIngredients()
            Toast.makeText(requireContext(),
                "Successfully removed all Ingredients",
                Toast.LENGTH_SHORT).show()

        }
        builder.setNegativeButton("No"){_,_->}
        builder.setTitle("Delete everything?")
        builder.setMessage("Are you sure you want to delete everything?")
        builder.create().show()
    }








}