package com.example.dado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val d6 = findViewById<Button>(R.id.button_d6)
        val d12 = findViewById<Button>(R.id.button_d12)
        val d20 = findViewById<Button>(R.id.button_d20)

        d6.setOnClickListener {
            //Toast.makeText(this, "Clicamos no Botão", Toast.LENGTH_SHORT).show()
            rolarDado(6)
        }
        d12.setOnClickListener {
            rolarDado(12)
        }
        d20.setOnClickListener {
            rolarDado(20)
        }


    }

    fun rolarDado(n: Int) {
        val valor = (1..n).random()

        val num = findViewById<TextView>(R.id.numero)

        num.text = valor.toString()
    }

}

