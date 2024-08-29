package br.com.alura.alugames.model
class PlanAssinatura(
    type: String,
    val fee: Double,
    val gamesIncluded: Int,
    val reputationDiscountPercentage: Double
): Plan(type){
    override fun priceCalculator(rent: Rent): Double {
        val totalGames = rent.gamer.gamesOfTheMonth(rent.period.inicialDate.monthValue).size + 1

        return if (totalGames <= gamesIncluded) 0.0 else {
            var originalPrice = super.priceCalculator(rent)
            if (rent.gamer.average > 8){
                originalPrice -= originalPrice * reputationDiscountPercentage
            }
            originalPrice
        }

    }
}
