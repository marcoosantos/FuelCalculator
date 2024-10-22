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

class ConsumoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_consumo)

        val edtConsumo = findViewById<TextInputEditText>(R.id.edt_consumo)

        val btn_proximo2 = findViewById<Button>(R.id.btn_proximo2)

        btn_proximo2.setOnClickListener {

            val consumoStr: String = edtConsumo.text.toString()
            val preco = intent.getFloatExtra(KEY_PRECO, 0f)

            if (consumoStr == "") {

                Snackbar
                    .make(
                        edtConsumo,
                        "Preencha todos os campos",
                        Snackbar.LENGTH_LONG
                    )
                    .show()
            } else {

                val consumo = consumoStr.toFloat()

                val intent = Intent(this, DistanceActivity::class.java)
                intent.putExtra(KEY_CONSUMO, consumo)
                intent.putExtra(KEY_PRECO, preco)
                startActivity(intent)
            }
        }
    }
}