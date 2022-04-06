package org.ay.gcu.honoursprojectkotlinversion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import org.ay.gcu.honoursprojectkotlinversion.databinding.FragmentThirdBinding


class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentThirdBinding.inflate(inflater, container, false)

        val question1 = resources.getStringArray(R.array.question1)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.survey_dropdown_item, question1)
        binding.autoCompleteTextView5.setAdapter(arrayAdapter)

        return binding.root
    }
override fun onDestroyView(){
    super.onDestroyView()
    _binding = null
}

}