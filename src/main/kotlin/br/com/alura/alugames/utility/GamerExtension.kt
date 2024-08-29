package br.com.alura.alugames.utility

import br.com.alura.alugames.model.Gamer
import br.com.alura.alugames.model.GamerInfoJson

fun GamerInfoJson.gamerConverter(): Gamer {
    return Gamer(
        this.name,
        this.email,
        this.birthDate,
        this.user
    )
}

