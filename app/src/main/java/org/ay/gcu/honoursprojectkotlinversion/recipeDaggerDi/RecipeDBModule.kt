package org.ay.gcu.honoursprojectkotlinversion.recipeDaggerDi

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.ay.gcu.honoursprojectkotlinversion.data.RecipeDatabase
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RecipeDBModule {
    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        RecipeDatabase::class.java,
        "recipe_database"

    ).createFromAsset("database/recipe.db").build()

    @Singleton
    @Provides
    fun provideDao(database: RecipeDatabase) = database.recipeDao()
}