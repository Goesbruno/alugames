package br.com.alura.alugames.model

import java.time.LocalDate
import java.time.Period

data class Rent(
    val gamer: Gamer,
    val game: Game,
    val period: br.com.alura.alugames.model.Period
) {
    val rentPrice = gamer.plan.priceCalculator(this)
    override fun toString(): String {
        return "Aluguel do ${game.title} por ${gamer.name} pelo valor de $rentPrice."
    }
}