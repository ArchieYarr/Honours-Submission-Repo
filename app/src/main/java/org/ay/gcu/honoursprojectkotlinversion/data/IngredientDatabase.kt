package org.ay.gcu.honoursprojectkotlinversion.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized
import org.ay.gcu.honoursprojectkotlinversion.IngredientsModel.Ingredient


@Database(entities = [Ingredient :: class], version = 1, exportSchema = false)
abstract class IngredientDatabase: RoomDatabase() {

    abstract fun ingredientDao(): IngredientDao

    companion object {
        @Volatile
        private var INSTANCE: IngredientDatabase? = null

        @OptIn(InternalCoroutinesApi::class)
        fun getDatabase(context: Context): IngredientDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    IngredientDatabase::class.java,
                    "ingredient_database"
                ).build()
                INSTANCE = instance
                return instance
            }

        }

    }
}