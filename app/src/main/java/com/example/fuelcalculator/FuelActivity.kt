package com.example.fuelcalculator

import android.content.Intent
import android.content.IntentSender
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class FuelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fuel)

        val edtValor = findViewById<TextInputEditText>(R.id.edt_valor)

        val btn_proximo = findViewById<Button>(R.id.btn_proximo)

        btn_proximo.setOnClickListener {

            val valorStr: String = edtValor.text.toString()

            if (valorStr == "") {

                Snackbar
                    .make(
                        edtValor,
                        "Preencha todos os campos",
                        Snackbar.LENGTH_LONG
                    )
                    .show()
            } else {

                val valor = valorStr.toFloat()

                val intent = Intent(this, ConsumoActivity::class.java)
                intent.putExtra(KEY_PRECO, valor)
                startActivity(intent)
            }
        }
    }
}
