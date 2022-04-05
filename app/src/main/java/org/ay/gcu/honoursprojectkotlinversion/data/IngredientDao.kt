package org.ay.gcu.honoursprojectkotlinversion.data

import androidx.lifecycle.LiveData
import androidx.room.*
import org.ay.gcu.honoursprojectkotlinversion.IngredientsModel.Ingredient

@Dao
interface IngredientDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addIngredient(ingredient: Ingredient)

    @Update
    suspend fun updateIngredient(ingredient: Ingredient)

    @Delete
    suspend fun deleteIngredient(ingredient: Ingredient)

    @Query( "DELETE FROM ingredient_table")
    suspend fun deleteAllIngredients()



        @Query("SELECT * FROM ingredient_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Ingredient>>
}