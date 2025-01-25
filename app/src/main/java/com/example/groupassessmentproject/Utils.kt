package com.example.groupassessmentproject

import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class Utils {
    fun fadeInImageViewAnimationCustom(image: ImageView, duration:Long, alpha:Float){
        image.alpha = 0f
        image.animate().alpha(alpha).setDuration(duration)
    }
    fun fadeInEditTextAnimationCustom(editText: EditText, duration:Long, alpha:Float){
        editText.alpha = 0f
        editText.animate().alpha(alpha).setDuration(duration)
    }
    fun fadeInTextViewAnimationCustom(textView: TextView, duration:Long, alpha:Float){
        textView.alpha = 0f
        textView.animate().alpha(alpha).setDuration(duration)
    }
    fun fadeInButtonViewAnimationCustom(btn: Button, duration:Long, alpha:Float){
        btn.alpha = 0f
        btn.animate().alpha(alpha).setDuration(duration)
    }

    fun fadeOutConstrainLayout(layout:ConstraintLayout,duration:Long){ layout.animate().alpha(0f).setDuration(duration) }
    fun fadeOutImageViewAnimationCustom(image: ImageView, duration:Long){ image.animate().alpha(0f).setDuration(duration) }
    fun fadeOutEditTextAnimationCustom(editText: EditText, duration:Long){ editText.animate().alpha(0f).setDuration(duration) }
    fun fadeOutTextViewAnimationCustom(textView: TextView, duration:Long){ textView.animate().alpha(0f).setDuration(duration) }
    fun fadeOutButtonViewAnimationCustom(btn: Button, duration:Long){ btn.animate().alpha(0f).setDuration(duration) }
}