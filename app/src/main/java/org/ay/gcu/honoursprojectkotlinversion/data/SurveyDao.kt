package org.ay.gcu.honoursprojectkotlinversion.data

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import org.ay.gcu.honoursprojectkotlinversion.surveyModel.Survey

interface SurveyDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addSurvey(survey: Survey)
}