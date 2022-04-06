package org.ay.gcu.honoursprojectkotlinversion.recipeModel

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "recipe_table")
data class Recipe(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val recipeName: String,
    val recipeIng: String,
    val recipeMethod: String

)
