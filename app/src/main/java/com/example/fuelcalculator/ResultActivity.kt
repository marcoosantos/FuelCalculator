package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT ="ResultActivity.KEY_FC"
const val KEY_DISTANCE ="DistanceActivity.KEY_FC"


class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_RESULT, 0f)
        val preco = intent.getFloatExtra(KEY_PRECO, 0f)
        val distance = intent.getFloatExtra(KEY_DISTANCE, 0f)
        val consumo = intent.getFloatExtra(KEY_CONSUMO, 0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvPreco = findViewById<TextView>(R.id.tv_preco)
        val tvConsumo = findViewById<TextView>(R.id.tv_consumo)
        val tvDistance = findViewById<TextView>(R.id.tv_distance)
        val btn_Inicio = findViewById<Button>(R.id.btn_inicio)

        tvResult.text ="R$" + result.toString()
        tvPreco.text = "Preco     " + preco.toString()
        tvConsumo.text = "Consumo     " + consumo.toString()
        tvDistance.text = "Distancia     " + distance.toString()

        btn_Inicio.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
        }
    }