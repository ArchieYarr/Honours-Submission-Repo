package org.ay.gcu.honoursprojectkotlinversion.surveyViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.ay.gcu.honoursprojectkotlinversion.data.SurveyDatabase
import org.ay.gcu.honoursprojectkotlinversion.surveyModel.Survey
import org.ay.gcu.honoursprojectkotlinversion.surveyRepository.SurveyRepository

class SurveyViewModel(application: Application): AndroidViewModel(application) {

    //private val readAllData: LiveData<List<Survey>>
   private val repository: SurveyRepository

    init{
        val surveyDao = SurveyDatabase.getDatabase(application).surveyDao()
        repository = SurveyRepository(surveyDao)
       //readAllData = repository.readAllData
    }

    fun addSurvey(survey: Survey){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addSurvey(survey)
        }
    }
}