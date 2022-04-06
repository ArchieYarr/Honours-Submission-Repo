package org.ay.gcu.honoursprojectkotlinversion.surveyRepository

import androidx.lifecycle.LiveData
import org.ay.gcu.honoursprojectkotlinversion.data.SurveyDao
import org.ay.gcu.honoursprojectkotlinversion.surveyModel.Survey

class SurveyRepository(private val surveyDao: SurveyDao) {

    //val readAllData: LiveData<List<Survey>> = SurveyDao.readAllData()

    suspend fun addSurvey(survey: Survey){
        surveyDao.addSurvey(survey)
    }
}