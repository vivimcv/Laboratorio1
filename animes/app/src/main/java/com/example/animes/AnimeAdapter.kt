package com.example.animes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.animes.databinding.ElementoListaBinding
import com.example.animes.model.anime

class AnimeAdapter(private val contexto: Context,val datos: ArrayList<anime>):BaseAdapter() {

    private val layoutInflater = LayoutInflater.from(contexto)
    override fun getCount(): Int {
        return datos.size
    }

    override fun getItem(p0: Int): Any {
        //p0 es la posición
        return datos[p0]
    }

    override fun getItemId(p0: Int): Long {
        return datos[p0].id
    }
//llenando la lista
    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        val binding = ElementoListaBinding.inflate(layoutInflater)
        with(binding){
            tvTitulo.text = datos[position].titulo
            tvTipo.text = datos[position].tipo
            tvfecha.text = datos[position].fecha
        }
    return binding.root
    }

}