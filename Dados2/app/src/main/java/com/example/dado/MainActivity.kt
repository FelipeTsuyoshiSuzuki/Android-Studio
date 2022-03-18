package com.example.dado

import android.content.Intent
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
        var opc: String
        val intentJogar = Intent(this, JogarActivity::class.java)

        d6.setOnClickListener {
            //Toast.makeText(this, "Clicamos no Botão", Toast.LENGTH_SHORT).show()
            opc = "D6"
            intentJogar.putExtra("OPÇÃO", opc)
            intentJogar.putExtra("DADO", 6)
            startActivity(intentJogar)

        }
        d12.setOnClickListener {
            opc = "D12"
            intentJogar.putExtra("OPÇÃO", opc)
            intentJogar.putExtra("DADO", 12)
            startActivity(intentJogar)
        }
        d20.setOnClickListener {
            opc = "D20"
            intentJogar.putExtra("OPÇÃO", opc)
            intentJogar.putExtra("DADO", 20)
            startActivity(intentJogar)

        }


    }


}

