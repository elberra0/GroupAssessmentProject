package com.example.groupassessmentproject
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.groupassessmentproject.data.local.AppDataSharedPreferences
import com.example.groupassessmentproject.models.remote.WorkoutPlan
import com.example.groupassessmentproject.services.RetrofitInstance
import com.google.gson.Gson
import com.example.groupassessmentproject.helpers.NetworkUtils
import kotlinx.coroutines.runBlocking

class InfoActivity : AppCompatActivity() {

    private val _appDataSharedPreferences = AppDataSharedPreferences()
    private val gson = Gson()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val objetivos = resources.getStringArray(R.array.objetivo)
        val adapterObjetivos = ArrayAdapter(this, android.R.layout.simple_spinner_item, objetivos)
        adapterObjetivos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val sexosItems = resources.getStringArray(R.array.sexosItems)
        val adaptersexosItems = ArrayAdapter(this, android.R.layout.simple_spinner_item, sexosItems)
        adaptersexosItems.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val plaesItems = resources.getStringArray(R.array.Planes)
        val adapterplaesItems = ArrayAdapter(this, android.R.layout.simple_spinner_item, plaesItems)
        adapterplaesItems.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val ageEditText: EditText = findViewById(R.id.ageEditText)
        val sexSpinner: Spinner = findViewById(R.id.sexSpinner)
        val weightEditText: EditText = findViewById(R.id.weightEditText)
        val heightEditText: EditText = findViewById(R.id.heightEditText)
        val spinnerObjetivo: Spinner = findViewById(R.id.SpinnerObjetivo)
        val submitButton: Button = findViewById(R.id.submitButton)

        spinnerObjetivo.adapter = adapterObjetivos
        sexSpinner.adapter = adaptersexosItems

        submitButton.setOnClickListener {
            if(!(NetworkUtils.isInternetAvailable(this)))
            {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Error de conectividad")
                    .setMessage("Actualmente no tienes conexión a Internet. Intenta conectarte a una red Wi-Fi o activar los datos móviles en tu celular.")
                    .setPositiveButton("Sí") { dialog, which ->
                    }

                val dialog = builder.create()
                dialog.show()
                return@setOnClickListener
            }

            var puntos: Int = 0
            var apiError = false
            var errorMsg = StringBuilder()
            if(ageEditText.text.isNullOrBlank())
            {
                errorMsg.appendLine("Debe espeficicar su edad.")
            }

            if(weightEditText.text.isNullOrBlank())
            {
                errorMsg.appendLine("Debe espeficicar su peso.")

            }

            if(heightEditText.text.isNullOrBlank())
            {
                errorMsg.appendLine("Debe espeficicar su altura.")
            }

            if(!(errorMsg.toString().isNullOrBlank())) {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Valicaciones faltantes")
                    .setMessage(errorMsg.toString())
                    .setPositiveButton("Sí") { dialog, which ->
                    }

                val dialog = builder.create()
                dialog.show()

                return@setOnClickListener
            }

            val age =   ageEditText.text.toString().toInt()
            val sex = sexSpinner.selectedItem.toString()
            val weight = weightEditText.text.toString().toDouble()
            val height = heightEditText.text.toString().toDouble()
            val objetivo = spinnerObjetivo.selectedItem.toString()

            puntos = evaluarPuntos(age,sex,weight,height,objetivo)

            var planEvaluado = ""
            when (puntos) {
                in 0..7 -> planEvaluado = "Recomendación de mantenimiento o impacto bajo"
                in 8..11 -> planEvaluado = "Recomendación equilibrada"
                in 12..99 -> planEvaluado = "Recomendación de alto rendimiento"
            }

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Se le recomienda el siguiente Plan")
                .setMessage(planEvaluado)
                .setPositiveButton("Sí") { dialog, which ->
                    var planId: Int = 0

                    when (puntos) {
                        in 0..7 -> planId = 3
                        in 8..11 -> planId = 2
                        in 12..99 -> planId = 1
                    }
                    _appDataSharedPreferences.savePlan(applicationContext, planId)
                    var workoutPlan: WorkoutPlan? = null

                    runBlocking {

                        try {
                            workoutPlan = RetrofitInstance.apiService.getPlanById(planId)
                        } catch (e: Exception) {
                            apiError = true

                        }
                    }

                    if(!apiError) {
                        var remoteJson = gson.toJson(workoutPlan)
                        _appDataSharedPreferences.saveJson(this, remoteJson)
                        finish()
                    }
                    else
                    {
                        Toast.makeText(this, "Algo anda mal con nuestro servidor, favor intentarlo mas tarde.", Toast.LENGTH_LONG).show()
                    }
                }
                .setNegativeButton("No") { dialog, which ->

                }

            val dialog = builder.create()
            dialog.show()
        }
    }
}

private fun evaluarPuntos(age: Int, sex: String,weight: Double,height: Double,objetivo: String): Int {

    var puntosPuntos = 0

    when (age) {
        in 18..30 -> puntosPuntos += 3
        in 31..50 -> puntosPuntos += 2
        else -> puntosPuntos += 1
    }

    when (sex) {
        in "Hombre" -> puntosPuntos += 2
        else -> puntosPuntos += 1
    }

    when (weight) {
        in 0.0..59.0 -> puntosPuntos += 2
        in 60.0..80.0 -> puntosPuntos += 1
        else -> puntosPuntos += 3
    }

    when (height) {
        in 0.0..1.59 -> puntosPuntos += 1
        in 1.60..1.8 -> puntosPuntos += 2
        else -> puntosPuntos += 3
    }

    when (objetivo) {
        in "Mantener peso" -> puntosPuntos += 2
        else -> puntosPuntos += 3
    }

    return puntosPuntos
}
