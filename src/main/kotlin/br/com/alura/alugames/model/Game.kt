package br.com.alura.alugames.model

import com.google.gson.annotations.Expose

data class Game (
    @Expose
    val title: String,
    @Expose
    val thumb: String
) : Recommendable {
    var description: String? = null
    var price = 0.0
    private val ratingList = mutableListOf<Int>()
    override val average: Double
        get() = ratingList.average()

    constructor(
        title: String,
        thumb: String,
        description: String?,
        price: Double
    ) : this(title, thumb){
        this.description = description
        this.price = price
    }

    override fun toString(): String {
        return  "\nJogo:\n" +
                "Título: $title\n" +
                "Capa: $thumb\n" +
                "Descrição: $description\n" +
                "Preço: $price\n" +
                "Nota: $average"
    }


}