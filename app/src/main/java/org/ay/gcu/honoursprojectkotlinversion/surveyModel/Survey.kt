package org.ay.gcu.honoursprojectkotlinversion.surveyModel

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "survey_table")
data class Survey(
    @PrimaryKey(autoGenerate = false)
    val user: String,
    val preUseAttitude: String,
    val PostUseAttitude: String,
    val preUseWaste: String,
    val postUseWaste: String,
): Parcelable
