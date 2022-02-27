package com.example.animes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.animes.databinding.ActivityMainBinding
import com.example.animes.model.anime

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val datos = ArrayList<anime>()
//llenando el arraylist
        for(i in 1 until 10){
            val animeTmp =anime(i.toLong(),  "Título $i", "Tipo $i", "Fecha $i")
            datos.add(animeTmp)
        }

        with(binding) {
            lvAnimes.adapter = AnimeAdapter(this@MainActivity, datos)
           lvAnimes.setOnItemClickListener { adapterView, view, i, l ->

               val animeSelect =adapterView.adapter.getItem(i) as anime
               Toast.makeText(this@MainActivity, "El título del anime seleccionado es: ${animeSelect.titulo}", Toast.LENGTH_LONG).show()


           }
                //i es la posicion
                //l es el id
               // Toast.makeText(this@MainActivity,"Se hizo $l",LON).show()


            }




        }
    }
