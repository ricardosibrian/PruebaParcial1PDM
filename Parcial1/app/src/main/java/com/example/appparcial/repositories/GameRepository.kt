package com.example.appparcial.repositories

import com.example.appparcial.data.model.GameModel

class GameRepository(private val games:MutableList<GameModel> ) {

    fun getGames() = games

    fun addGame(newGame: GameModel) = games.add(newGame)

}