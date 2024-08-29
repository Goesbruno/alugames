package br.com.alura.alugames.model

class PlanAvulso(
    type: String
) : Plan(type) {

    override fun priceCalculator(rent: Rent): Double {
        var originalPrice = super.priceCalculator(rent)
        if (rent.gamer.average > 8) {
            originalPrice -= originalPrice * 0.1
        }
            return originalPrice
    }

}
