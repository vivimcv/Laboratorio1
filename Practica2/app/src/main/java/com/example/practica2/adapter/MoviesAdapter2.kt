package com.example.practica2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practica2.adapter.MoviesAdapter2.MovieHolder
import com.example.practica2.model.Movies


class MoviesAdapter2(context: Context, listMovies: ArrayList<Movies>): RecyclerView.Adapter<MoviesAdapter2.MovieHolder>(){
    private val listMovies = listMovies
    private val layoutInflater = LayoutInflater.from(context)
    override fun getCount(): Int {
        return listMovies.size
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesAdapter2.MovieHolder {
        return listMovies[p0]

    }

    override fun onBindViewHolder(holder: MoviesAdapter2.MovieHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return listMovies[p0]

    }

    class MovieHolder(val view: View):RecyclerView.ViewHolder(view){
        fun render(movies: Movies){
        }

    }
}