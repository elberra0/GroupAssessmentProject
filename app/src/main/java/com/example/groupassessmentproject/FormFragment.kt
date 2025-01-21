package com.example.groupassessmentproject
import android.app.Application
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.groupassessmentproject.data.local.AppDataSharedPreferences

class FormFragment : Fragment() {
    private val _appDataSharedPreferences = AppDataSharedPreferences()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
    {
        val binding = inflater.inflate(R.layout.fragment_form, container, false)

        val bntFromTest: Button = binding.findViewById(R.id.btnFormTest)
        val btnSeePlanning: Button = binding.findViewById(R.id.btnSeePlanning)

        bntFromTest.setOnClickListener {
            val intent = Intent(requireActivity(), InfoActivity::class.java)
            startActivity(intent)
        }

        btnSeePlanning.setOnClickListener {
            val planId = _appDataSharedPreferences.getPlan(requireContext())
            if (planId != 0) {
                val intent = Intent(requireActivity(), WorkoutPlanActivity()::class.java)
                startActivity(intent)
            }
            else
            {
                Toast.makeText(context, "No tiene un plan asignado.Favor realizar el Do test.", Toast.LENGTH_LONG).show()
            }
        }

       return  binding
    }
}