package org.ay.gcu.honoursprojectkotlinversion.data

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow
import org.ay.gcu.honoursprojectkotlinversion.IngredientsModel.Ingredient

import org.ay.gcu.honoursprojectkotlinversion.recipeModel.Recipe


@Dao
interface RecipeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addRecipe(recipe: Recipe)
    @Delete
    suspend fun deleteRecipe(recipe: Recipe)

    @Query("SELECT * FROM recipe_table ORDER BY recipeid ASC")
    fun readAll(): LiveData<List<Recipe>>

    @Query("SELECT * FROM recipe_table WHERE recipeName LIKE :recipeSearchQuery OR recipeIng LIKE :recipeSearchQuery OR recipeMethod LIKE :recipeSearchQuery")
    fun searchRecipeDatabase(recipeSearchQuery: String): Flow<List<Recipe>>
}
