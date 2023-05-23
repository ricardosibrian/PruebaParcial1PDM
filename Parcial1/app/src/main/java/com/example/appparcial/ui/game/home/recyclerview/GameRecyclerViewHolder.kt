package com.example.appparcial.ui.game.home.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.appparcial.data.model.GameModel
import com.example.appparcial.databinding.GameItemBinding

class GameRecyclerViewHolder(private val binding: GameItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(game: GameModel, clickListener: (GameModel) -> Unit) {
        binding.Title.text = game.name
        binding.secondTitle.text = game.genre

        binding.card.setOnClickListener {
            clickListener(game)
        }
    }
}