package org.ay.gcu.honoursprojectkotlinversion.ingredientRepository

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow
import org.ay.gcu.honoursprojectkotlinversion.IngredientsModel.Ingredient
import org.ay.gcu.honoursprojectkotlinversion.data.IngredientDao

class IngredientRepository(private val ingredientDao: IngredientDao) {

    val readAllData: LiveData<List<Ingredient>> = ingredientDao.readAllData()

    suspend fun addIngredient(ingredient: Ingredient){
        ingredientDao.addIngredient(ingredient)
    }

    suspend fun updateIngredient(ingredient: Ingredient){
        ingredientDao.updateIngredient(ingredient)
    }

    suspend fun deleteIngredient(ingredient: Ingredient){
        ingredientDao.deleteIngredient(ingredient)
    }

    suspend fun deleteAllIngredients(){
        ingredientDao.deleteAllIngredients()
    }



}