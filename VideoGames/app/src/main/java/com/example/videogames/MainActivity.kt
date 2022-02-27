package com.example.videogames

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.videogames.adapter.GamesAdapter
import com.example.videogames.databinding.ActivityMainBinding
import com.example.videogames.db.DBgames
import com.example.videogames.model.Game

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listGames:ArrayList<Game>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        ////
        val dbGame=DBgames(this)
        listGames=dbGame.getGames()

        if(listGames.size==0) binding.tvSinRegistros.visibility = View.VISIBLE
        else binding.tvSinRegistros.visibility = View.INVISIBLE

        val gamesAdapter = GamesAdapter(this, listGames)

        binding.lvGames.adapter=gamesAdapter
        binding.lvGames.setOnItemClickListener { adapterView, view, i, l ->

            //mandando a la lista de detalles
            val intent=Intent(this, Details_Activity::class.java)
            intent.putExtra("ID",l.toInt())
            startActivity(intent)
            finish()

        }


        //probando la generación de la db
        /* val dbHelper = DBHelper(this)
         val db= dbHelper.writableDatabase
         if(db!=null){
             Toast.makeText(this,"ÉXITO al crear la db",Toast.LENGTH_LONG)

         }else{
             Toast.makeText(this,"Error al crear la db",Toast.LENGTH_LONG)
         }*/
    }

    fun click(view: View) {

        startActivity(Intent(this, InsertActivity::class.java))
        finish()
        //eventos
        /*
        val dbGames = DBgames(this)

        with(binding){

            if(!tilTitulo.text.toString().isEmpty() && !tietGenre.text.toString().isEmpty() && !tietDeveloper.text.toString().isEmpty()){
                val id = dbGames.insertGame(tietTitulo.text.toString(), tietGenre.text.toString(), tietDeveloper.text.toString())

                if(id > 0) { //el registro se insertó correctamente
                    Toast.makeText(this@InsertActivity, "Registro guardado exitosamente", Toast.LENGTH_LONG).show()

                    //Reiniciamos las cajas de texto
                    tietTitulo.setText("")
                    tietGenre.setText("")
                    tietDeveloper.setText("")
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

*/
    }
}