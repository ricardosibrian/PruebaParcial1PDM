package com.example.appparcial.ui.game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.appparcial.GameReviewerApplication
import com.example.appparcial.data.model.GameModel
import com.example.appparcial.repositories.GameRepository

class GameViewModel(private val repository: GameRepository): ViewModel() {

    fun getGames() = repository.getGames()
    fun addGame(game: GameModel) = repository.addGame(game)

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as GameReviewerApplication
                GameViewModel(app.gameRepository)
            }
        }
    }

}