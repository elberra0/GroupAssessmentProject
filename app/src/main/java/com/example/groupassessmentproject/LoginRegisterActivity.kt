package com.example.groupassessmentproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.groupassessmentproject.databinding.ActivityLoginRegisterBinding

class LoginRegisterActivity : AppCompatActivity() {
    private val ANIMATIONTIME:Long = 1500
    private val utils = Utils()
    private val view by lazy { ActivityLoginRegisterBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        fadeInAnimations()
        logIn()
        signIn()
    }

    private fun logIn(){
        view.btnLogIn.setOnClickListener{
            if(SharedPreferences_(this).checkUserExists(view.etLoginUser.text.toString())){
                if(SharedPreferences_(this).getPassword(view.etLoginUser.text.toString())
                    == view.etPassword.text.toString()){
                    view.tvAlertMessage.text = "INICIANDO SESION JEJE GOD"
                }else{
                    view.etPassword.text.clear()
                    view.tvAlertMessage.text = "CONTRASEÑA INCORRECTA"
                }
            }else{
                view.etPassword.text.clear()
                view.tvAlertMessage.text = "USUARIO NO ENCONTRADO NECESITAS REGISTRARTE"
            }
        }
    }

    private fun signIn(){
        view.btnSignIn.setOnClickListener{
            if(SharedPreferences_(this).checkUserExists(view.etLoginUser.text.toString())){
                view.tvAlertMessage.text = "USUARIO YA EXISTENTE EN LA BASE DE DATOS"
            }else{
                SharedPreferences_(this).saveCredentials(
                    view.etLoginUser.text.toString(),
                    view.etPassword.text.toString())
                view.tvAlertMessage.text = "USUARIO REGISTRADO"
            }
        }
    }

    private fun fadeInAnimations(){
        view.etLoginUser.alpha = 0f
        view.etPassword.alpha = 0f
        view.btnLogIn.alpha = 0f
        view.btnSignIn.alpha = 0f
        view.ivBackground.alpha = 0f
        view.tvAppName.alpha = 0f

        utils.fadeInButtonViewAnimationCustom(view.btnLogIn,ANIMATIONTIME,1f)
        utils.fadeInButtonViewAnimationCustom(view.btnSignIn,ANIMATIONTIME,1f)
        utils.fadeInEditTextAnimationCustom(view.etLoginUser,ANIMATIONTIME,1f)
        utils.fadeInEditTextAnimationCustom(view.etPassword,ANIMATIONTIME,1f)
        utils.fadeInImageViewAnimationCustom(view.ivBackground,ANIMATIONTIME,1f)
        utils.fadeInTextViewAnimationCustom(view.tvAppName,ANIMATIONTIME,1f)
    }
}