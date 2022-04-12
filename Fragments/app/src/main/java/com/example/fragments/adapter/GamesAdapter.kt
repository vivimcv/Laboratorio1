package com.example.fragments.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fragments.databinding.GameElementBinding
import com.example.fragments.model.Game

class GamesAdapter(private val context: Context, val games:ArrayList<Game>,val onItemListener: OnItemListener): RecyclerView.Adapter<GamesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = GameElementBinding.inflate(layoutInflater)

        return ViewHolder(binding,onItemListener)

    }

    override fun onBindViewHolder(holder: GamesAdapter.ViewHolder, position: Int) {
        holder.bindData(games[position])
    }

    override fun getItemCount(): Int {
       return games.size
    }

    interface OnItemListener{
        fun onItemClick(game: Game)
    }

    class ViewHolder(binding: GameElementBinding,onItemListener: OnItemListener):RecyclerView.ViewHolder(binding.root), View.OnClickListener{
        private val binding=binding
        private val onItemListener = onItemListener
        private lateinit var game: Game

        init{
            binding.root.setOnClickListener(this)

        }
        override fun onClick(p0:View?){
            onItemListener.onItemClick(game)
        }


        fun bindData(item:Game){
            with(binding){
                tvTitle.text = item.title
                tvGenre.text = item.genre
                tvDeveloper.text = item.developer
            }
            game = item

        }

    }
}


