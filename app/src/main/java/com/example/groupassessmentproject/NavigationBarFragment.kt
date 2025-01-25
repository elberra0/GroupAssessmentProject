package com.example.groupassessmentproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.groupassessmentproject.databinding.FragmentNavigationBarBinding

class NavigationBarFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
    {
        val view = FragmentNavigationBarBinding.inflate(inflater, container, false)
        val fragmentManager = requireActivity().supportFragmentManager

        view.btnHome.setOnClickListener{
            val homeFragment = FormFragment()

            fragmentManager.beginTransaction()
                .replace(R.id.main_view_fragment, homeFragment)
                .commit()
        }

        view.btnOptions.setOnClickListener{
            val editDataFragment = EditDataFragment()

            fragmentManager.beginTransaction()
            .replace(R.id.main_view_fragment, editDataFragment)
            .commit()
        }

        view.btnMap.setOnClickListener{
            val mapFragment = MapGymFragment()

            fragmentManager.beginTransaction()
                .replace(R.id.main_view_fragment, mapFragment)
                .commit()
        }

        return view.root
    }
}