package org.ay.gcu.honoursprojectkotlinversion.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

import org.ay.gcu.honoursprojectkotlinversion.recipeModel.Recipe


@Dao
interface RecipeDao {

    @Query("SELECT * FROM recipe_table ORDER BY recipeName ASC")
    fun readAll(): LiveData<List<Recipe>>
}