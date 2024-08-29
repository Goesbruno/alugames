package br.com.alura.alugames.utility

import br.com.alura.alugames.model.Game
import br.com.alura.alugames.model.GameInfoJson

fun GameInfoJson.gameConverter(): Game {
    return Game(
        this.title,
        this.thumb,
        this.description,
        this.price)
}
