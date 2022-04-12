package com.example.fragments.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.fragments.databinding.ActivityMainBinding
import com.example.fragments.databinding.AnimesElementBinding
import com.example.fragments.model.Anime

class AnimesAdapter(private val context: Context, val datos:ArrayList<Anime>):BaseAdapter() {

    private  var layoutInflater = LayoutInflater.from(context)
    override fun getCount(): Int {
        return datos.size
    }

    override fun getItem(p0: Int): Any {
        return datos[p0]
    }

    override fun getItemId(p0: Int): Long {
        return datos[p0].id.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val binding = AnimesElementBinding.inflate(layoutInflater)

        with(binding) {
            tvTitulo.text = datos[p0].titulo
            tvTipo.text = datos[p0].tipo
            tvFecha.text = datos[p0].fecha
        }
        return binding.root
    }
}