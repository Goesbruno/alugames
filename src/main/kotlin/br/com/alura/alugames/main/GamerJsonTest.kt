package br.com.alura.alugames.main

import br.com.alura.alugames.model.Period
import br.com.alura.alugames.model.PlanAssinatura
import br.com.alura.alugames.services.ApiConsume
import com.google.gson.GsonBuilder
import java.io.File
import java.time.LocalDate

fun main() {
    val consume = ApiConsume()
    val gamerList = consume.gamerSearch()
    val gameList = consume.gameJsonSearch()
//    println(gamerList)
//    println(gameApi)

    val gamerCaroline = gamerList.get(3)
    val gameResidentVillage = gameList.get(10)
    val gameSpider = gameList.get(13)
    val gameTheLastOfUs = gameList.get(2)
    val gameDandara = gameList.get(5)


//    println(gamerCaroline)
//    println(gameResidentVillage)

    val period1 = Period(LocalDate.now(), LocalDate.now().plusDays(7))
    val period2 = Period(LocalDate.now(), LocalDate.now().plusDays(3))
    val period3= Period(LocalDate.now(), LocalDate.now().plusDays(10))

    gamerCaroline.rentGame(gameResidentVillage, period1)
    gamerCaroline.rentGame(gameSpider, period2)
    gamerCaroline.rentGame(gameTheLastOfUs, period3)

//    println(gamerCaroline.rentedGames)

    val gamerCamila = gamerList.get(5)
    gamerCamila.plan = PlanAssinatura("PRATA", 9.90, 3, 0.15)

    gamerCamila.rentGame(gameResidentVillage, period1)
    gamerCamila.rentGame(gameSpider, period2)
    gamerCamila.rentGame(gameTheLastOfUs, period3)
    gamerCamila.rentGame(gameDandara, period3)
//    println(gamerCamila.rentedGames)

    gamerCamila.recommend(7)
    gamerCamila.recommend(10)
    gamerCamila.recommend(8)
//    println(gamerCamila)

    gamerCamila.rentGame(gameDandara, period3)
//    println(gamerCamila.rentedGames)

    gamerCamila.gameRecommend(gameResidentVillage, 7)
    gamerCamila.gameRecommend(gameTheLastOfUs, 10)

    gamerCaroline.gameRecommend(gameResidentVillage, 8)
    gamerCaroline.gameRecommend(gameTheLastOfUs, 9)

//    println("Recomendações CAMILA")
//    println(gamerCamila.recommendedGames)
//    println("Recomendações CAROLINA")
//    println(gamerCaroline.recommendedGames)


    val gameAssassins = gameList.get(4)
    val gameCyber = gameList.get(6)
    val gameGod = gameList.get(7)
    val gameSkyrim = gameList.get(18)

    gamerCamila.gameRecommend(gameResidentVillage, 7)
    gamerCamila.gameRecommend(gameTheLastOfUs, 10)
    gamerCamila.gameRecommend(gameAssassins, 8)
    gamerCamila.gameRecommend(gameCyber, 7)
    gamerCamila.gameRecommend(gameGod, 10)
    gamerCamila.gameRecommend(gameDandara, 8)
    gamerCamila.gameRecommend(gameSkyrim, 8)
    gamerCamila.gameRecommend(gameSpider, 6)

    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    val serialization = gson.toJson(gamerCamila.recommendedGames)
    println(serialization)

    val file = File("recommendedGames${gamerCamila.name}.json")
    file.writeText(serialization)
    println(file.absolutePath)
}