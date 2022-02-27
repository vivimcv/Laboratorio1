package com.example.videogames

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.videogames.databinding.ActivityInsertBinding
import com.example.videogames.db.DBgames

class InsertActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInsertBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_insert)

        binding = ActivityInsertBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun click(view: View) {

        //eventos de click del botón flotante
      //  startActivity(Intent(this,InsertActivity::class.java))
      //  finish()

        val dBgames = DBgames(this)
        with(binding){
            //validando campos
            if (!tieTitulo.text.toString().isEmpty() && !tieGenero.text.toString().isEmpty()&& !tieDeveloper.text.toString().isEmpty()){

                val id = dBgames.insertGame(tieTitulo.text.toString(),tieDeveloper.text.toString(),tieGenero.text.toString())

                if(id > 0) { //el registro se insertó correctamente
                    Toast.makeText(this@InsertActivity, "Registro guardado exitosamente", Toast.LENGTH_LONG).show()

                    //Reiniciamos las cajas de texto
                    tieTitulo.setText("")
                    tieGenero.setText("")
                    tieDeveloper.setText("")
                    tieTitulo.requestFocus()
                }else{
                    Toast.makeText(this@InsertActivity, "Error al guardar el registro", Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(this@InsertActivity, "Por favor llene todos los campos", Toast.LENGTH_LONG).show()

                //Para mandar un error en una caja de texto especíica
                //tietTitulo.text = "Por favor agrega un título"
            }

        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, MainActivity::class.java))
}

}