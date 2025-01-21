package com.example.groupassessmentproject
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import android.widget.LinearLayout.LayoutParams
import android.widget.ImageView
import android.graphics.Color
import android.util.Log
import com.example.groupassessmentproject.data.local.AppDataSharedPreferences
import com.example.groupassessmentproject.models.Plan
import com.example.groupassessmentproject.models.remote.WorkoutPlan
import com.example.groupassessmentproject.services.RetrofitInstance
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlinx.coroutines.*

class WorkoutPlanActivity() : AppCompatActivity(){
    private val _appDataSharedPreferences = AppDataSharedPreferences()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_plan)

        var workoutPlan: WorkoutPlan? = null
        val planId = _appDataSharedPreferences.getPlan(this)
        runBlocking {

            workoutPlan = RetrofitInstance.apiService.getPlanById(planId)

            /*
            RetrofitInstance.apiService.getPlanById(1).enqueue(object : Callback<WorkoutPlan> {
                override fun onResponse(call: Call<WorkoutPlan>, response: Response<WorkoutPlan>) {
                    if (response.isSuccessful) {
                        workoutPlan = response.body()!!
                    }
                }

                override fun onFailure(call: Call<WorkoutPlan>, t: Throwable) {
                    Log.e("MainActivity", "Failure: ${t.message}")
                }
            })
            */
        }
        val workoutPlanContainer: LinearLayout = findViewById(R.id.workoutPlanContainer)

        val titleTextView = TextView(this).apply {
            text = workoutPlan?.clasificacion
            textSize = 23f
            setTextColor(Color.BLACK)
            setPadding(0, 0, 0, 16)
        }
        workoutPlanContainer.addView(titleTextView)

        workoutPlan?.ejercicios?.forEach { (day, plan) ->
            val dayTextView = TextView(this).apply {
                text = day.capitalize()
                textSize = 20f
                setTextColor(Color.BLACK)
                setPadding(0, 16, 0, 8)
                setTypeface(typeface, android.graphics.Typeface.BOLD)
            }
            workoutPlanContainer.addView(dayTextView)

            val dayPlanLayout = LinearLayout(this).apply {
                orientation = LinearLayout.VERTICAL
            }
            workoutPlanContainer.addView(dayPlanLayout)

            val tipoTextView = TextView(this).apply {
                text = plan.tipo
                textSize = 18f
                setTextColor(Color.DKGRAY)
                setTypeface(typeface, android.graphics.Typeface.BOLD)
            }
            dayPlanLayout.addView(tipoTextView)
            if (plan.calentamiento != "" && plan.calentamiento != null) {
                val calentamientoTitle = TextView(this).apply {
                    text = "Calentamiento:"
                    setTextColor(Color.BLACK)
                }
                dayPlanLayout.addView(calentamientoTitle)

                val calentamientoTextView = TextView(this).apply {
                    text = plan.calentamiento
                    setTextColor(Color.BLACK)
                }
                dayPlanLayout.addView(calentamientoTextView)
            }

            plan.ejercicios.forEach { exercise ->
                val exerciseLayout = LinearLayout(this).apply {
                    orientation = LinearLayout.VERTICAL
                    setPadding(16, 0, 0, 8)
                }
                dayPlanLayout.addView(exerciseLayout)

                val exerciseNameTextView = TextView(this).apply {
                    text = exercise.nombre
                    setTextColor(Color.BLACK)
                    setTextSize(18f)
                    setTypeface(typeface, android.graphics.Typeface.BOLD)
                }
                exerciseLayout.addView(exerciseNameTextView)

                if (exercise.series > 0) {
                    val seriesTextView = TextView(this).apply {
                        text = "Series: ${exercise.series}"
                        setTextColor(Color.BLACK)
                    }
                    exerciseLayout.addView(seriesTextView)
                }

                if (exercise.repeticiones != null) {
                    val repeticionesTextView = TextView(this).apply {
                        text = "Repeticiones: ${exercise.repeticiones}"
                        setTextColor(Color.BLACK)
                    }
                    exerciseLayout.addView(repeticionesTextView)
                }
            }

            if (!plan.enfriamiento.isNullOrBlank()) {
                val enfriamientoTitle = TextView(this).apply {
                    text = "Enfriamiento:"
                    setTextColor(Color.BLACK)
                }
                dayPlanLayout.addView(enfriamientoTitle)

                val enfriamientoTextView = TextView(this).apply {
                    text = plan.enfriamiento
                    setTextColor(Color.BLACK)
                }
                dayPlanLayout.addView(enfriamientoTextView)
            }
        }

        val consejosTitle = TextView(this).apply {
            text = "Consejos"
            textSize = 20f
            setTextColor(Color.BLACK)
            setPadding(0, 16, 0, 8)
        }
        workoutPlanContainer.addView(consejosTitle)

        workoutPlan?.consejos?.forEach { consejo ->
            val consejoTextView = TextView(this).apply {
                text = "• $consejo"
                setTextColor(Color.BLACK)
                setPadding(0, 4, 0, 4)
            }
            workoutPlanContainer.addView(consejoTextView)
        }

        val nutricionTitle = TextView(this).apply {
            text = "Nutrición"
            textSize = 20f
            setTextColor(Color.BLACK)
            setPadding(0, 16, 0, 8)
        }
        workoutPlanContainer.addView(nutricionTitle)

        val macronutrientesTitle = TextView(this).apply {
            text = "Macronutrientes:"
            setTextColor(Color.BLACK)
        }
        workoutPlanContainer.addView(macronutrientesTitle)

        workoutPlan?.nutricion?.principios?.macronutrientes?.forEach { (macro, value) ->
            val macroTextView = TextView(this).apply {
                text = "$macro: $value"
                setTextColor(Color.BLACK)
            }
            workoutPlanContainer.addView(macroTextView)
        }

        // Nutrición - Plan de Comidas
        workoutPlan?.nutricion?.plan_comidas?.forEach { (meal, details) ->
            val mealTitle = TextView(this).apply {
                text = meal.replace("_", " ").capitalize()
                setTextColor(Color.BLACK)
                setPadding(0, 8, 0, 4)
            }
            workoutPlanContainer.addView(mealTitle)

            details.alimentos.forEach { alimento ->
                val alimentoTextView = TextView(this).apply {
                    text = "• $alimento"
                    setTextColor(Color.BLACK)
                    setPadding(0, 0, 0, 4)
                }
                workoutPlanContainer.addView(alimentoTextView)
            }
        }
    }
}