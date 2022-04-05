package org.ay.gcu.honoursprojectkotlinversion.ingredientViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.ay.gcu.honoursprojectkotlinversion.IngredientsModel.Ingredient
import org.ay.gcu.honoursprojectkotlinversion.data.IngredientDatabase
import org.ay.gcu.honoursprojectkotlinversion.ingredientRepository.IngredientRepository

class IngredientViewModel(application: Application) : AndroidViewModel(application) {
     val readAlldata: LiveData<List<Ingredient>>
    private val repository: IngredientRepository

    init {
        val ingredientDao = IngredientDatabase.getDatabase(application).ingredientDao()
        repository = IngredientRepository(ingredientDao)
        readAlldata = repository.readAllData

    }
    fun addIngredient(ingredient: Ingredient){
        viewModelScope.launch(Dispatchers.IO){
            repository.addIngredient(ingredient)
        }
    }

    fun updateIngredient(ingredient: Ingredient){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateIngredient(ingredient)
        }
    }

    fun deleteIngredient(ingredient: Ingredient){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteIngredient(ingredient)
        }
    }

    fun deleteAllIngredients(){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteAllIngredients()
        }
    }
}