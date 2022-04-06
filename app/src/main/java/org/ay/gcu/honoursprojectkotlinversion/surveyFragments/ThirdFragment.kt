package org.ay.gcu.honoursprojectkotlinversion.surveyFragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_third.*
import kotlinx.android.synthetic.main.fragment_third.view.*
import org.ay.gcu.honoursprojectkotlinversion.R
import org.ay.gcu.honoursprojectkotlinversion.surveyModel.Survey
import org.ay.gcu.honoursprojectkotlinversion.surveyViewModel.SurveyViewModel


class ThirdFragment : Fragment() {

    private lateinit var surveyViewModel: SurveyViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_third, container, false)

        surveyViewModel = ViewModelProvider(this).get(SurveyViewModel::class.java)

        view.surveySubmit.setOnClickListener{
            insertDatatoDatabase()
        }

        return view
    }
private fun insertDatatoDatabase(){

    val user = surveyName_et.text.toString()
    val qOneAnswer = surveyq1_et.text.toString()
    val qTwoAnswer = surveyq2_et.text.toString()

    if (inputCheck(user, qOneAnswer, qTwoAnswer)){
        //create Survey object
        val survey = Survey(user, qOneAnswer, qTwoAnswer)

        //add the survey to the database
        surveyViewModel.addSurvey(survey)
        Toast.makeText(requireContext(), "Survey successfully submitted!", Toast.LENGTH_LONG).show()

    }else{
        Toast.makeText(requireContext(), "Please fill out all fields!", Toast.LENGTH_LONG).show()
    }
}

    fun inputCheck(user: String, qOneAnswer: String, qTwoAnswer: String): Boolean{
        return !(TextUtils.isEmpty(user) && TextUtils.isEmpty(qOneAnswer) && TextUtils.isEmpty(qTwoAnswer))
    }
}