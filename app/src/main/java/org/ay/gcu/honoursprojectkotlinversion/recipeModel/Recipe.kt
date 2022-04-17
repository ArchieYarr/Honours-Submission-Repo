package org.ay.gcu.honoursprojectkotlinversion.recipeModel

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "recipe_table")
data class Recipe(
    @PrimaryKey(autoGenerate = true)
    val recipeid: Int,
    val recipeName: String,
    val recipeIng: String,
    val recipeMethod: String

): Parcelable
