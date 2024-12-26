package com.example.groupassessmentproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import com.example.groupassessmentproject.databinding.FragmentLogInBinding

class LogInFragment : Fragment() {
    private val ANIMATIONTIME:Long = 200
    private val utils = Utils()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
    {
        val view = FragmentLogInBinding.inflate(inflater, container, false)
        fadeInAnimations(view)
        logIn(view)
        loadSignInFragment(view)
        return view.root
    }

    private fun logIn(view: FragmentLogInBinding){
        view.btnLogIn.setOnClickListener{
            if(SharedPreferences_(requireActivity()).checkUserExists(view.etLoginUser.text.toString())){
                if(SharedPreferences_(requireActivity()).getPassword(view.etLoginUser.text.toString())
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

    private fun loadSignInFragment(view: FragmentLogInBinding){
        view.btnSignIn.setOnClickListener{
            val signInFragment = SignInFragment()
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmentLogIn = this

            val animation: Animation = android.view.animation.AnimationUtils.loadAnimation(context, R.anim.scale_down_anim)

            view.main.startAnimation(animation)

            animation.setAnimationListener(object : AnimationListener {
                override fun onAnimationStart(a: Animation) {
                    fadeOutAnimations(view)
                }
                override fun onAnimationRepeat(a: Animation) {}
                override fun onAnimationEnd(a: Animation) {
                    fragmentManager.beginTransaction()
                        .hide(fragmentLogIn)
                        .replace(R.id.fragment_sign_in, signInFragment)
                        .commit()
                }
            })
        }
    }

    private fun fadeOutAnimations(view:FragmentLogInBinding){
        utils.fadeOutButtonViewAnimationCustom(view.btnLogIn,ANIMATIONTIME)
        utils.fadeOutButtonViewAnimationCustom(view.btnSignIn,ANIMATIONTIME)
        utils.fadeOutEditTextAnimationCustom(view.etLoginUser,ANIMATIONTIME)
        utils.fadeOutEditTextAnimationCustom(view.etPassword,ANIMATIONTIME)
        utils.fadeOutImageViewAnimationCustom(view.ivBackground,ANIMATIONTIME)
        utils.fadeOutTextViewAnimationCustom(view.tvAppName,ANIMATIONTIME)
    }

    private fun fadeInAnimations(view: FragmentLogInBinding){
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