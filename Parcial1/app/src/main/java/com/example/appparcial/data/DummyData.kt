package com.example.appparcial.data

import com.example.appparcial.data.model.GameModel

val name = "Clash Royale"
val genre = "Mobile game"
val description = "Clash Royale's description"
val calification = "9.4"

val name2 = "Resident Evil 2"
val genre2 = "Horror"
val description2 = "Resident Evil's description"
val calification2 = "9.3"

var games = mutableListOf(
    GameModel(name, genre, description, calification),
    GameModel(name2, genre2, description2, calification2)
)