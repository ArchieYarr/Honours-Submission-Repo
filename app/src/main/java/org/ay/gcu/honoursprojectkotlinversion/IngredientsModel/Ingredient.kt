package org.ay.gcu.honoursprojectkotlinversion.IngredientsModel

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "ingredient_table")
data class Ingredient(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val ingredientName: String,
    val ingredientCategory: String,
    val ingredientQuantity: Int
        ): Parcelable
