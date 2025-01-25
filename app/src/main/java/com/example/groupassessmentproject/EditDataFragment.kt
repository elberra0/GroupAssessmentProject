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
        val mainActivity = activity as? MainActivity
        val username = mainActivity?.currentUsername

        val view = FragmentEditDataBinding.inflate(inflater, container, false)
        view.btnSaveData.setOnClickListener{
            if(!view.etEditUsername.text.isNullOrBlank()){
                editUserName(view,username)
            }

            if(!view.etEditPassword.text.isNullOrBlank() &&
                !view.etConfirmEditPassword.text.isNullOrBlank()){
                editPassword(view,username)
            }
        }
        return view.root
    }

    private fun editUserName(view:FragmentEditDataBinding,username:String?){
        if(SharedPreferences_(requireActivity()).
            changeUserName(username.toString(),view.etEditUsername.text.toString(),)){
            view.tvAlertMessage.text = "USUARIO CAMBIADO CORRECTAMENTE"
        }else{
            view.tvAlertMessage.text = "HA HABIDO UN PROBLEMA AL CAMBIAR EL NOMBRE"
        }
    }

    private fun editPassword(view: FragmentEditDataBinding,username: String?){
        if(view.etEditPassword.text.toString() == view.etConfirmEditPassword.text.toString()){
            if(SharedPreferences_(requireActivity()).changePassword(view.etEditPassword.text.toString(),
                   username!!)){
                SharedPreferences_(requireActivity()).saveCredentials(username,
                    view.etEditPassword.text.toString() )
                view.tvAlertMessage.text = "CONTRASEÑA CAMBIADA CORRECTAMENTE"
            }
        }else{
            view.tvAlertMessage.text = "LAS CONTRASEÑAS NO COINCIDEN"
        }
    }

}