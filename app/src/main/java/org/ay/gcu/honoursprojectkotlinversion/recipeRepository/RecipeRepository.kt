package org.ay.gcu.honoursprojectkotlinversion.recipeRepository
import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow
import org.ay.gcu.honoursprojectkotlinversion.IngredientsModel.Ingredient
import org.ay.gcu.honoursprojectkotlinversion.data.RecipeDao
import org.ay.gcu.honoursprojectkotlinversion.recipeModel.Recipe
import javax.inject.Inject


class RecipeRepository (
    private val recipeDao: RecipeDao

    ){
    val readAll: LiveData<List<Recipe>> = recipeDao.readAll()

    suspend fun addRecipe(recipe: Recipe){
        recipeDao.addRecipe(recipe)
    }

    suspend fun deleteRecipe(recipe: Recipe){
        recipeDao.deleteRecipe(recipe)
    }

    fun searchRecipeDatabase(recipeSearchQuery: String): Flow<List<Recipe>> {
        return recipeDao.searchRecipeDatabase(recipeSearchQuery)
    }
}
