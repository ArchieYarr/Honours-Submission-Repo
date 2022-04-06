package org.ay.gcu.honoursprojectkotlinversion.data

import androidx.room.Database
import androidx.room.RoomDatabase
import org.ay.gcu.honoursprojectkotlinversion.recipeModel.Recipe


@Database(entities = [Recipe :: class], version = 1, exportSchema = false)
abstract class RecipeDatabase: RoomDatabase() {
    abstract fun recipeDao(): RecipeDao
}