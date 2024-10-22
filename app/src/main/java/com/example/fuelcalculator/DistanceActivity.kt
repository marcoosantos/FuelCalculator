package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

const val KEY_PRECO = "FuelActivity.KEY_FC"
const val KEY_CONSUMO = "ConsumoActivity.KEY_FC"

class DistanceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_distance)

        val edtDistance = findViewById<TextInputEditText>(R.id.edt_distance)

        val btnCalcular = findViewById<Button>(R.id.btn_calcular)

        val preco = intent.getFloatExtra(KEY_PRECO, 0f)
        val consumo = intent.getFloatExtra(KEY_CONSUMO, 0f)

        btnCalcular.setOnClickListener {

            val distanceStr: String = edtDistance.text.toString()

            if (distanceStr == "") {

                Snackbar
                    .make(
                        edtDistance,
                        "Preencha todos os campos",
                        Snackbar.LENGTH_LONG
                    )
                    .show()
            } else {

                val distance = distanceStr.toFloat()

                val result = distance * preco / consumo

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(KEY_RESULT, result)
                intent.putExtra(KEY_DISTANCE, distance)
                intent.putExtra(KEY_CONSUMO, consumo)
                intent.putExtra(KEY_PRECO, preco)
                startActivity(intent)
            }
        }
    }
}