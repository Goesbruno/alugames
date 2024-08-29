package br.com.alura.alugames.main

import br.com.alura.alugames.model.Game
import br.com.alura.alugames.model.Gamer
import br.com.alura.alugames.services.ApiConsume
import br.com.alura.alugames.utility.toAgeFormatter
import java.util.*


fun main() {

    val imput = Scanner(System.`in`)
    val gamer = Gamer.gamerCreate(imput)
    println("Cadastro concluído com sucesso. Dados do gamer:")
    println(gamer)

    println("Idade do gamer: " + gamer.birthDate?.toAgeFormatter())
    do {
        println("Digite o código de jogo para buscar:")
        val search = imput.nextLine()

        val apiSearch = ApiConsume()
        val gameInfo = apiSearch.gameSearch(search)

        var myGame: Game? = null

        val result = runCatching {
            myGame = Game(
                gameInfo.info.title,
                gameInfo.info.thumb
            )
        }

        result.onFailure {
            println("Jogo Inexistente, tente outro id.")
        }
        result.onSuccess {
            println("Deseja inserir um descrição personalizada? S/N")
            val option = imput.nextLine()
            if (option.equals("s", true)) {
                println("Insira a descrição personalizada para o jogo:")
                val newDesc = imput.nextLine()
                myGame?.description = newDesc
            } else {
                myGame?.description = myGame?.title
            }
            gamer.searchedGames.add(myGame)
        }
        println("Deseja buscar um novo jogo? S/N")
        val answer = imput.nextLine()
    } while (answer.equals("s", true))
    println("Jogos buscados:")
    println(gamer.searchedGames)

    println("\nJogos ordenado por título:")
    gamer.searchedGames.sortBy {
        it?.title
    }

    gamer.searchedGames.forEach {
        println("Título:" + it?.title)
    }
    println("Busca finalizada com sucesso")
}