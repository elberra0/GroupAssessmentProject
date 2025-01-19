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

        val exercisePlans = resources.getStringArray(R.array.exercise_plans)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, exercisePlans)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val ageEditText: EditText = findViewById(R.id.ageEditText)
        val sexEditText: EditText = findViewById(R.id.sexEditText)
        val weightEditText: EditText = findViewById(R.id.weightEditText)
        val heightEditText: EditText = findViewById(R.id.heightEditText)
        val exercisePlanSpinner: Spinner = findViewById(R.id.exercisePlanSpinner)
        val submitButton: Button = findViewById(R.id.submitButton)
        exercisePlanSpinner.adapter = adapter

        submitButton.setOnClickListener {
            val age = ageEditText.text.toString()
            val sex = sexEditText.text.toString()
            val weight = weightEditText.text.toString()
            val height = heightEditText.text.toString()
            val selectedPlan = exercisePlanSpinner.selectedItem.toString()

            Toast.makeText(this, "Formulario Enviado: $age, $sex, $weight, $height, $selectedPlan", Toast.LENGTH_LONG).show()
        }
    }
}
