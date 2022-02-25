package com.example.formulas

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.Log
import android.view.View
import android.widget.*

class Resultados : AppCompatActivity() {

    private lateinit var setImage: ImageView
    private lateinit var mp: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultados)
        mp = MediaPlayer.create(this, R.raw.magia)
        mp.start()


        val bundle = intent.extras
        val operacion = bundle?.getString("operacion", "")
        val resultado = bundle?.getDouble("resultado", 0.0)
       // Toast.makeText(this, resultado.toString(), Toast.LENGTH_SHORT).show()
       // Toast.makeText(this, operacion.toString(), Toast.LENGTH_SHORT).show()

        // Capture the layout's TextView and set the string as its text
        val textView = findViewById<TextView>(R.id.tvResultado).apply {
            text = resultado.toString()
        }
        //colocando la imagen elegida del spinner
        setImage = findViewById(R.id.ivResultado)
        val formulaNombre = findViewById<TextView>(R.id.tvFormulaElegida)
        val user_greeting = "hola"
        when (operacion) {
            "voltaje" -> {
                setImage.setImageResource(R.drawable.tension)

                formulaNombre.setText(getString(R.string.formulas1))
            }
            "corriente" -> {
                setImage.setImageResource(R.drawable.corriente)
                formulaNombre.setText(getString(R.string.formulas2))
            }
            "resistencia" -> {
                setImage.setImageResource(R.drawable.resistencia)
                formulaNombre.setText(getString(R.string.formulas3))
            }
            "potencia" -> {
                setImage.setImageResource(R.drawable.potencia)
                formulaNombre.setText(getString(R.string.formulas4))
            }
        }

        //colocando el nombre de la formula elegida


        fun click(view: View) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }




    }
    override fun onBackPressed() {
        super.onBackPressed()
    }
    override fun onStart() {
        super.onStart()
    }
    override fun onResume() {
        super.onResume()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}