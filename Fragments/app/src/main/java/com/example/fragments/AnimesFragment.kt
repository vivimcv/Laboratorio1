package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Toast
import androidx.fragment.app.FragmentResultListener
import com.example.fragments.adapter.AnimesAdapter
import com.example.fragments.databinding.AnimesElementBinding
import com.example.fragments.databinding.FragmentAnimesBinding
import com.example.fragments.model.Anime


class AnimesFragment : Fragment() {

    private lateinit var binding: FragmentAnimesBinding
    private  var datoRecibido: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        parentFragmentManager.setFragmentResultListener("datos", this, FragmentResultListener { requestKey, result ->

             datoRecibido = result.getString("dato1", "")

        })


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding= FragmentAnimesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val datos= ArrayList<Anime>()

        for (i in 1 until 20){

            val animeTmp =Anime(i,"Titulo $i","Tipo $i","Fecha $i")
            datos.add(animeTmp)
        }
        val adapter = AnimesAdapter(requireContext(),datos)

        binding.lvAnimes.adapter= adapter

        binding.lvAnimes.setOnItemClickListener { adapterView, view, i, l ->
            //i posicion
            //l id
            val animeSeleccionado =adapterView.adapter.getItem(i) as Anime

            //Toast.makeText(requireContext(),"Anime: ${animeSeleccionado.titulo}",Toast.LENGTH_SHORT ).show()
            //lo mismo pero en una variable:

            if (datoRecibido!=null){
                Toast.makeText(requireContext(),"Anime: $datoRecibido",Toast.LENGTH_LONG)

            }

        }
    }


}