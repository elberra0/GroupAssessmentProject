package com.example.groupassessmentproject

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class FormFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
    {
        val binding = inflater.inflate(R.layout.fragment_form, container, false)

        val bntFromTest: Button = binding.findViewById(R.id.btnFormTest)
        val btnSeePlanning: Button = binding.findViewById(R.id.btnSeePlanning)
        btnSeePlanning.setOnClickListener {
            val intent = Intent(requireActivity(), WorkoutPlanActivity::class.java)
            startActivity(intent)
        }

        bntFromTest.setOnClickListener {
            val intent = Intent(requireActivity(), InfoActivity::class.java)
            startActivity(intent)
        }

       return  binding
    }
}