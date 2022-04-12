package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fragments.adapter.GamesAdapter
import com.example.fragments.databinding.FragmentGamesBinding
import com.example.fragments.model.Game


class GamesFragment : Fragment(), GamesAdapter.OnItemListener {

    private lateinit var bindind: FragmentGamesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindind=FragmentGamesBinding.inflate(inflater, container, false)
        return bindind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val datos = ArrayList<Game>()

        for (i in 1 until 20){
            val gameTmp = Game(i,"Titulo $i", "Genero$i", "Desarrollador $i")
            datos.add(gameTmp)
        }
        val adapter = GamesAdapter(requireContext(),datos,this)
        with(bindind){
            rvGames.layoutManager = LinearLayoutManager(requireContext())
            rvGames.adapter = adapter
        }
    }


    override fun onItemClick(game: Game) {
        Toast.makeText(requireContext(),"juego${game.title}", Toast.LENGTH_SHORT).show()

        val bundle =Bundle()
        bundle.putString("dato1","${game.title}")
        parentFragmentManager.setFragmentResult("datos",bundle)
    }


}