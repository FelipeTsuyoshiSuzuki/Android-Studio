package com.example.dado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class JogarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jogar)

        // Referenciando aos componentes da activity
        val titulo = findViewById<TextView>(R.id.titulo)
        val nCaiu = findViewById<TextView>(R.id.textNumero)
        val buttonJogar = findViewById<Button>(R.id.buttonJogar)
        val buttonVoltar = findViewById<Button>(R.id.buttonVoltar)

        // Recuperando dados da main
        val dado = intent.getStringExtra("OPÇÃO")
        val lados = intent.getIntExtra("DADO", 0)

        titulo.text = dado
        buttonJogar.text = dado

        buttonJogar.setOnClickListener {
            nCaiu.text = rolarDado(lados)
        }

        buttonVoltar.setOnClickListener {
            finish()
        }

    }
    // Função de lançar dados
    fun rolarDado(n: Int): String {
        val valor = (1..n).random()

        return valor.toString()
    }
}