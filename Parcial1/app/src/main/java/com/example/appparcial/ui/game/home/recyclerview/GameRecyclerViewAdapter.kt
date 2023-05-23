package com.example.appparcial.ui.game.home.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appparcial.data.model.GameModel
import com.example.appparcial.databinding.GameItemBinding

class GameRecyclerViewAdapter(private val clickListener: (GameModel) -> Unit) : RecyclerView.Adapter<GameRecyclerViewHolder>() {
    private val games = ArrayList<GameModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameRecyclerViewHolder {
        val binding = GameItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GameRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GameRecyclerViewHolder, position: Int) {
        val game = games[position]
        holder.bind(game, clickListener)
    }

    override fun getItemCount(): Int {
        return games.size
    }

    fun setData(gameList: List<GameModel>) {
        games.clear()
        games.addAll(gameList)
    }
}