package com.example.appparcial

import android.app.Application
import com.example.appparcial.data.games
import com.example.appparcial.repositories.GameRepository

class GameReviewerApplication : Application() {
    val gameRepository: GameRepository by lazy {
        GameRepository(games)
    }
}