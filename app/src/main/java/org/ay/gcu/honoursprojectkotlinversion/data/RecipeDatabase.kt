package org.ay.gcu.honoursprojectkotlinversion.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi
import org.ay.gcu.honoursprojectkotlinversion.recipeModel.Recipe


@Database(entities = [Recipe :: class], version = 1, exportSchema = false)
abstract class RecipeDatabase: RoomDatabase() {
    abstract fun recipeDao(): RecipeDao


    companion object {
        @Volatile
        private var INSTANCE: RecipeDatabase? = null

        @OptIn(InternalCoroutinesApi::class)
        fun getRecipeDatabase(context: Context): RecipeDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            kotlinx.coroutines.internal.synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RecipeDatabase::class.java,
                    "recipe_database"
                ).build()
                INSTANCE = instance
                return instance
            }

        }

    }
}