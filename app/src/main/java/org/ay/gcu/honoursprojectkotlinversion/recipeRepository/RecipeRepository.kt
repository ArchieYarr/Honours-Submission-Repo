package org.ay.gcu.honoursprojectkotlinversion.recipeRepository
import org.ay.gcu.honoursprojectkotlinversion.data.RecipeDao
import javax.inject.Inject


class RecipeRepository @Inject constructor (
    private val recipeDao: RecipeDao

    ){
    val readAll = recipeDao.readAll()
}
