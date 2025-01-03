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
            if(arguments?.getString("username") != null){
                editUserName(view)
            }

            if(view.etEditPassword.text != null ||
                view.etConfirmEditPassword.text != null){
                editPassword(view)
            }
        }
        return view.root
    }

    private fun editUserName(view:FragmentEditDataBinding){
        if(SharedPreferences_(requireActivity()).
            changeUserName(arguments?.getString("username").toString(),view.etEditUsername.text.toString(),)){
            view.tvAlertMessage.text = "USUARIO CAMBIADO CORRECTAMENTE"
        }else{
            view.tvAlertMessage.text = "HA HABIDO UN PROBLEMA AL CAMBIAR EL NOMBRE"
        }
    }

    private fun editPassword(view: FragmentEditDataBinding){
        if(view.etEditPassword.text.toString() == view.etConfirmEditPassword.text.toString()){
            if(SharedPreferences_(requireActivity()).changePassword(view.etEditPassword.text.toString(),
                    arguments?.getString("username")!!)){
                SharedPreferences_(requireActivity()).saveCredentials(arguments?.getString("username")!!,
                    view.etEditPassword.text.toString() )
                view.tvAlertMessage.text = "CONTRASEÑA CAMBIADA CORRECTAMENTE"
            }
        }else{
            view.tvAlertMessage.text = "LAS CONTRASEÑAS NO COINCIDEN"
        }
    }

}