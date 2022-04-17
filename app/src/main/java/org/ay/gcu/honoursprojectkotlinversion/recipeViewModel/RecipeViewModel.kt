package org.ay.gcu.honoursprojectkotlinversion.recipeViewModel

import android.app.Application
import androidx.lifecycle.*

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.ay.gcu.honoursprojectkotlinversion.IngredientsModel.Ingredient
import org.ay.gcu.honoursprojectkotlinversion.data.RecipeDatabase

import org.ay.gcu.honoursprojectkotlinversion.data.RecipeDatabase.Companion.getRecipeDatabase


import org.ay.gcu.honoursprojectkotlinversion.recipeModel.Recipe
import org.ay.gcu.honoursprojectkotlinversion.recipeRepository.RecipeRepository
import javax.inject.Inject


@HiltViewModel
class RecipeViewModel @Inject constructor(application: Application): AndroidViewModel(application) {

        val readAll: LiveData<List<Recipe>>
        private val recipeRepository: RecipeRepository


        init {
                val recipeDao = RecipeDatabase.getRecipeDatabase(application).recipeDao()
                recipeRepository = RecipeRepository(recipeDao)
                readAll = recipeRepository.readAll

        }

        fun addRecipe(recipe: Recipe){
                viewModelScope.launch(Dispatchers.IO){
                        recipeRepository.addRecipe(recipe)
                }
        }

        fun deleteRecipe(recipe: Recipe){
                viewModelScope.launch(Dispatchers.IO){
                        recipeRepository.deleteRecipe(recipe)
                }
        }

       

}