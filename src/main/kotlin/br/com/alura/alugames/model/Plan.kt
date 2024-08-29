package br.com.alura.alugames.model

abstract class Plan(
    val type: String
) {
    open fun priceCalculator(rent: Rent): Double{
        return rent.game.price * rent.period.inDays
    }
}