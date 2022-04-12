package com.example.practica2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.practica2.databinding.ActivityInsertBinding
import com.example.practica2.db.DBmovies

class InsertActivity: AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private lateinit var binding: ActivityInsertBinding
    private lateinit var spinnview: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInsertBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //generando spinner
        val Generos = ArrayAdapter<String>(this,
            android.R.layout.simple_spinner_dropdown_item)
        Generos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        //definiendo géneros
      Generos.addAll(listOf(getString(R.string.Género1),getString(R.string.Género2),getString(R.string.Género3),getString(R.string.Género4),getString(R.string.Género5),getString(R.string.Género6)))

       binding.tietSpiner.onItemSelectedListener = this
        binding.tietSpiner.adapter = Generos



    }
    fun click(view: View) {

        val dBmovies = DBmovies(this)

        with(binding){

            val seleccion = tietSpiner.selectedItemId.toString()
            val textSeleccion = Bundle()



                //!tietSpiner.toString().isEmpty()
                //tietSpiner.toString()

                if(!tietTitulo.text.toString().isEmpty() && !seleccion.toString().isEmpty() && !tietYear.text.toString().isEmpty()&& !tietDirector.text.toString().isEmpty()){
/*
                    //para mandar texto del spinner
                    textSeleccion.putString("genero",seleccion)
                    intent.putExtras(textSeleccion)
                    startActivity(intent)
                    Toast.makeText(this@InsertActivity, seleccion, Toast.LENGTH_LONG).show()
                    //
*/
                    val id = dBmovies.insertMovie(tietTitulo.text.toString(),seleccion.toInt(), tietYear.text.toString(),tietDirector.text.toString())
                   // Toast.makeText(this@InsertActivity, "seleccion ${seleccion.toInt()}", Toast.LENGTH_LONG).show()
                    if(id > 0) { //el registro se insertó correctamente
                        Toast.makeText(this@InsertActivity, "Registro guardado exitosamente", Toast.LENGTH_LONG).show()

                        //Reiniciamos las cajas de texto
                        tietTitulo.setText("")
                       // tietGenre.setText("")

                        tietYear.setText("")
                        tietDirector.setText("")
                        tietTitulo.requestFocus()
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

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        //Salvar la posición y valor del item actual
      //  this.p0 = p0;
       // selection = parent.getItemAtPosition(position).toString();

        //Mostramos la selección actual del Spinner
       // Toast.makeText(this,"Selección actual: "+selection,Toast.LENGTH_SHORT).show();
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }

}