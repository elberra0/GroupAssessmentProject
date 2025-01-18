package com.example.groupassessmentproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.groupassessmentproject.databinding.FragmentFormBinding

class FormFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
    {
        val view = FragmentFormBinding.inflate(inflater, container, false)
        return view.root
    }

}