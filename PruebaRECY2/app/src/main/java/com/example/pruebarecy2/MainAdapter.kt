package com.example.pruebarecy2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pruebarecy2.databinding.AdapterMovieBinding

class MainAdapter: RecyclerView.Adapter<MainViewHolder>() {
    var movies = mutableListOf<Restaurante>()
    fun setMovieList(movies: List<Restaurante>) {
        this.movies = movies.toMutableList()
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterMovieBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val movie = movies[position]
        holder.binding.name.text = movie.nombre
        Glide.with(holder.itemView.context).load(movie.imageUrl).into(holder.binding.imageview)
        holder.binding.tvCal.text = movie.calificacion
        holder.binding.tvCosto.text = movie.costopromedio.toString()
        holder.binding.tvYear.text = movie.año.toString()
    }
    override fun getItemCount(): Int {
        return movies.size
    }
}
class MainViewHolder(val binding: AdapterMovieBinding) : RecyclerView.ViewHolder(binding.root) {
}