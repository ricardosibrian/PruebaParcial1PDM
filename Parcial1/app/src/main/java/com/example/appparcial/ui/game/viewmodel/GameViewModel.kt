package com.example.appparcial.ui.game.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.appparcial.GameReviewerApplication
import com.example.appparcial.data.model.GameModel
import com.example.appparcial.repositories.GameRepository

class GameViewModel(private val repository: GameRepository): ViewModel() {

    // Aqui se implementa LiveData
    var name = MutableLiveData("")
    var genre = MutableLiveData("")
    var description = MutableLiveData("")
    var calification = MutableLiveData("")
    var status = MutableLiveData("")

    fun getGames() = repository.getGames()
    fun addGame(game: GameModel) = repository.addGame(game)

    fun createGame() {
        if (!validateData()) {
            status.value = WRONG_DATA
            return
        }

        val newGame = GameModel(
            name.value!!,
            genre.value!!,
            description.value!!,
            calification.value!!
        )

        addGame(newGame)
        clearData()

        status.value = GAME_CREATED
    }

    private fun validateData(): Boolean {
        when {
            name.value.isNullOrEmpty() -> return false
            genre.value.isNullOrEmpty() -> return false
            description.value.isNullOrEmpty() -> return false
            calification.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun clearData() {
        name.value = ""
        genre.value = ""
        description.value = ""
        calification.value = ""
    }

    fun clearStatus() {
        status.value = INACTIVE
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as GameReviewerApplication
                GameViewModel(app.gameRepository)
            }
        }

        const val GAME_CREATED = "Game created"
        const val WRONG_DATA = "Wrong data"
        const val INACTIVE = ""
    }

}