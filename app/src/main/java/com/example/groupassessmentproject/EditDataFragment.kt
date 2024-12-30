package com.example.groupassessmentproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.groupassessmentproject.databinding.FragmentEditDataBinding

class EditDataFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
    {
        val view = FragmentEditDataBinding.inflate(inflater, container, false)
        view.btnSaveData.setOnClickListener{

        }
        return view.root
    }

    private fun editUserName(){

    }

    private fun editPassword(){

    }

}