package br.com.alura.alugames.main

import br.com.alura.alugames.model.Gamer

fun main() {
    val gamer1 = Gamer(
        "Bruno",
        "bruno@email.com",
        birthDate = "17/10/1997",
        user = "Goesbruno",
    )
    println(gamer1)
    val gamer2 = Gamer(
        "PlayerUnknown",
        "emailshow@mail.com",
        birthDate = "01/07/2024",
        user = "unknownGamer0102"
    )
    println(gamer2)
    gamer2.let {
        it.user = "zé"
    }
    println(gamer2)
}