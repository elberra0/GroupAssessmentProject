package com.example.groupassessmentproject
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class InfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val objetivos = resources.getStringArray(R.array.objetivo)
        val adapterObjetivos = ArrayAdapter(this, android.R.layout.simple_spinner_item, objetivos)
        adapterObjetivos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val sexosItems = resources.getStringArray(R.array.sexosItems)
        val adaptersexosItems = ArrayAdapter(this, android.R.layout.simple_spinner_item, sexosItems)
        adaptersexosItems.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val ageEditText: EditText = findViewById(R.id.ageEditText)
        val sexSpinner: Spinner = findViewById(R.id.sexSpinner)
        val weightEditText: EditText = findViewById(R.id.weightEditText)
        val heightEditText: EditText = findViewById(R.id.heightEditText)
        val exercisePlanSpinner: Spinner = findViewById(R.id.exercisePlanSpinner)
        val submitButton: Button = findViewById(R.id.submitButton)

        exercisePlanSpinner.adapter = adapterObjetivos
        sexSpinner.adapter = adaptersexosItems


        submitButton.setOnClickListener {
            var puntos: Int = 0

            val age =   ageEditText.text.toString().toInt()
            val sex = sexSpinner.selectedItem.toString()
            val weight = weightEditText.text.toString().toDouble()
            val height = heightEditText.text.toString().toDouble()
            val objetivo = exercisePlanSpinner.selectedItem.toString()

            puntos = evaluarPuntos(age,sex,weight,height,objetivo)

            Toast.makeText(this, "total de puntos: $puntos", Toast.LENGTH_LONG).show()
        }
    }
}

private fun evaluarPuntos(
    age: Int,
    sex: String,
    weight: Double,
    height: Double,
    objetivo: String
): Int {
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
