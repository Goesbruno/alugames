package br.com.alura.alugames.model

interface Recommendable {
    val average: Double

    fun recommend(rating: Int) {

    }
}