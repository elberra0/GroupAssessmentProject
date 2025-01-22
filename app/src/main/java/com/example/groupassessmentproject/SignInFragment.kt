package com.example.groupassessmentproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import com.example.groupassessmentproject.databinding.FragmentSignInBinding

class SignInFragment : Fragment() {
    private val ANIMATION_TIME:Long = 200
    private val utils = Utils()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
    {
        val view = FragmentSignInBinding.inflate(inflater, container, false)
        fadeInAnimations(view)
        loadLogInFragment(view)
        signIn(view)
        return view.root
    }

    private fun loadLogInFragment(view: FragmentSignInBinding){
        view.btnLogIn.setOnClickListener{
            val signInFragment = this
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmentLogIn = LogInFragment()

            val animation: Animation = android.view.animation.AnimationUtils.loadAnimation(context, R.anim.scale_down_anim)

            view.main.startAnimation(animation)

            animation.setAnimationListener(object : AnimationListener {
                override fun onAnimationStart(a: Animation) {
                    fadeOutAnimations(view)
                }
                override fun onAnimationRepeat(a: Animation) {}
                override fun onAnimationEnd(a: Animation) {
                    fragmentManager.beginTransaction()
                        .hide(signInFragment)
                        .replace(R.id.fragment_log_in, fragmentLogIn)
                        .commit()
                }
            })
        }
    }

    private fun signIn(view: FragmentSignInBinding){
        view.btnSignIn.setOnClickListener{
            if(SharedPreferences_(requireActivity()).checkUserExists(view.etLoginUser.text.toString())){
                view.tvAlertMessage.text = "USUARIO YA EXISTENTE EN LA BASE DE DATOS"
            }else{
                if(view.etConfirmPassword.text.toString() != view.etPassword.text.toString()){
                    view.tvAlertMessage.text = "LAS CONTRASEÑAS NO COINCIDEN"
                }else{
                    SharedPreferences_(requireActivity()).saveCredentials(
                        view.etLoginUser.text.toString(),
                        view.etPassword.text.toString())
                    view.tvAlertMessage.text = "USUARIO REGISTRADO"
                }
            }
        }
    }

    private fun fadeOutAnimations(view: FragmentSignInBinding){
        utils.fadeOutButtonViewAnimationCustom(view.btnLogIn,ANIMATION_TIME)
        utils.fadeOutButtonViewAnimationCustom(view.btnSignIn,ANIMATION_TIME)
        utils.fadeOutEditTextAnimationCustom(view.etLoginUser,ANIMATION_TIME)
        utils.fadeOutEditTextAnimationCustom(view.etPassword,ANIMATION_TIME)
        utils.fadeOutEditTextAnimationCustom(view.etConfirmPassword,ANIMATION_TIME)
        utils.fadeOutImageViewAnimationCustom(view.ivBackground,ANIMATION_TIME)
        utils.fadeOutTextViewAnimationCustom(view.tvAppName,ANIMATION_TIME)
    }

    private fun fadeInAnimations(view: FragmentSignInBinding){
        view.etLoginUser.alpha = 0f
        view.etPassword.alpha = 0f
        view.etConfirmPassword.alpha = 0f
        view.btnLogIn.alpha = 0f
        view.btnSignIn.alpha = 0f
        view.ivBackground.alpha = 0f
        view.tvAppName.alpha = 0f

        utils.fadeInButtonViewAnimationCustom(view.btnLogIn,ANIMATION_TIME,1f)
        utils.fadeInButtonViewAnimationCustom(view.btnSignIn,ANIMATION_TIME,1f)
        utils.fadeInEditTextAnimationCustom(view.etLoginUser,ANIMATION_TIME,1f)
        utils.fadeInEditTextAnimationCustom(view.etPassword,ANIMATION_TIME,1f)
        utils.fadeInEditTextAnimationCustom(view.etConfirmPassword,ANIMATION_TIME,1f)
        utils.fadeInImageViewAnimationCustom(view.ivBackground,ANIMATION_TIME,0.3f)
        utils.fadeInTextViewAnimationCustom(view.tvAppName,ANIMATION_TIME,1f)
    }

}