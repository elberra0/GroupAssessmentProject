package com.example.groupassessmentproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import com.example.groupassessmentproject.databinding.FragmentLogInBinding
import com.example.groupassessmentproject.models.DataApp
import com.example.groupassessmentproject.services.PersistenceService
import com.example.groupassessmentproject.services.RetrofitInstance
import com.google.android.gms.tasks.Tasks.await
import kotlinx.coroutines.*
import okhttp3.internal.wait
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LogInFragment : Fragment() {
    private val ANIMATIONTIME:Long = 200
    private val utils = Utils()
    private val api = PersistenceService

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
    {
        val view = FragmentLogInBinding.inflate(inflater, container, false)
        fadeInAnimations(view)
        logIn(view)
        loadSignInFragment(view)
        return view.root
    }

    private fun logIn(view: FragmentLogInBinding){
        view.btnFormTest.setOnClickListener{

           /*
            val scope = CoroutineScope(Dispatchers.Main)
            scope.launch {
                val ramon = async { api.shared.load() }
                api.shared.load().wait()
                var x = 1
            }
            */

            /*
            RetrofitInstance.apiService.getData().enqueue(object : Callback<DataApp> {
                override fun onResponse(call: Call<DataApp>, response: Response<DataApp>) {
                    if (response.isSuccessful) {
                         response.body()!!.Clasificaciones?.forEach {

                         }
                    }
                }


                override fun onFailure(call: Call<DataApp>, t: Throwable) {
                    Log.e("MainActivity", "Failure: ${t.message}")
                }
            })

             */

            if(SharedPreferences_(requireActivity()).checkUserExists(view.etLoginUser.text.toString()))
            {
                if(SharedPreferences_(requireActivity()).getPassword(view.etLoginUser.text.toString()) == view.etPassword.text.toString())
                {
                    val editDataFragment = FormFragment()
                   // val fragmentManager = requireActivity().supportFragmentManager
                   //   val fragmentLogIn = this
                    val bundle = Bundle()
                    bundle.putString("username", view.etLoginUser.text.toString())
                    editDataFragment.arguments = bundle

                    val animation: Animation = android.view.animation.AnimationUtils.loadAnimation(context, R.anim.scale_down_anim)

                    view.main.startAnimation(animation)

                    animation.setAnimationListener(object : AnimationListener {
                        override fun onAnimationStart(a: Animation) {
                            fadeOutAnimations(view)
                        }
                        override fun onAnimationRepeat(a: Animation) {}
                        override fun onAnimationEnd(a: Animation) {
                            /*fragmentManager.beginTransaction()
                                .hide(fragmentLogIn)
                                .replace(R.id.fragment_sign_in, editDataFragment)
                                .commit()*/
                            val intent = Intent(requireActivity(), MainActivity::class.java)
                            startActivity(intent)
                        }
                    })

                }
                else{
                    view.etPassword.text.clear()
                    view.tvAlertMessage.text = "CONTRASEÑA INCORRECTA"
                }
            }
            else {
                view.etPassword.text.clear()
                view.tvAlertMessage.text = "USUARIO NO ENCONTRADO NECESITAS REGISTRARTE"
            }
        }
    }

    private fun logInChangeFragment(){
        //TODO: GO DIRECTLY TO EDIT DATA FRAGMENT BECAUSE WE DONT HAVE ANYTHING ELSE YET
    }

    private fun loadSignInFragment(view: FragmentLogInBinding){
        view.btnSeePlanning.setOnClickListener{
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
        utils.fadeOutButtonViewAnimationCustom(view.btnFormTest,ANIMATIONTIME)
        utils.fadeOutButtonViewAnimationCustom(view.btnSeePlanning,ANIMATIONTIME)
        utils.fadeOutEditTextAnimationCustom(view.etLoginUser,ANIMATIONTIME)
        utils.fadeOutEditTextAnimationCustom(view.etPassword,ANIMATIONTIME)
        utils.fadeOutImageViewAnimationCustom(view.ivBackground,ANIMATIONTIME)
        utils.fadeOutTextViewAnimationCustom(view.tvAppName,ANIMATIONTIME)
    }

    private fun fadeInAnimations(view: FragmentLogInBinding){
        view.etLoginUser.alpha = 0f
        view.etPassword.alpha = 0f
        view.btnFormTest.alpha = 0f
        view.btnSeePlanning.alpha = 0f
        view.ivBackground.alpha = 0f
        view.tvAppName.alpha = 0f

        utils.fadeInButtonViewAnimationCustom(view.btnFormTest,ANIMATIONTIME,1f)
        utils.fadeInButtonViewAnimationCustom(view.btnSeePlanning,ANIMATIONTIME,1f)
        utils.fadeInEditTextAnimationCustom(view.etLoginUser,ANIMATIONTIME,1f)
        utils.fadeInEditTextAnimationCustom(view.etPassword,ANIMATIONTIME,1f)
        utils.fadeInImageViewAnimationCustom(view.ivBackground,ANIMATIONTIME,1f)
        utils.fadeInTextViewAnimationCustom(view.tvAppName,ANIMATIONTIME,1f)
    }
}