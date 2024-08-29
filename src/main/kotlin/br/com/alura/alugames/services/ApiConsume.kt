package br.com.alura.alugames.services

import br.com.alura.alugames.model.*
import br.com.alura.alugames.utility.gameConverter
import br.com.alura.alugames.utility.gamerConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ApiConsume {

    private fun dataConsumer(address: String): String {
        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(address))
            .build()
        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        return response.body()
    }
    fun gameSearch(id:String): GameInfo {
        val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"
        val json = dataConsumer(endereco)

        val gson = Gson()
        val meuInfoJogo = gson.fromJson(json, GameInfo::class.java)

        return meuInfoJogo

    }
    fun gameJsonSearch(): List<Game> {
        val address = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"
        val json = dataConsumer(address)

        val gson = Gson()
        val type = object : TypeToken<List<GameInfoJson>>() {}.type

        val gameListJson: List<GameInfoJson> = gson.fromJson(json, type)

        val gameList = gameListJson.map { it.gameConverter() }
        return gameList
    }

    fun gamerSearch(): List<Gamer> {
        val address = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"
        val json = dataConsumer(address)

        val gson = Gson()
        val type = object : TypeToken<List<GamerInfoJson>>() {}.type
        val gamerList: List<GamerInfoJson> = gson.fromJson(json, type)

        val convertedGamerList = gamerList.map { gamerInfo ->
            gamerInfo.gamerConverter()
        }

        return convertedGamerList
    }
}