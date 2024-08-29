package br.com.alura.alugames.model

import com.google.gson.annotations.SerializedName

data class GameInfoJson(
    @SerializedName("titulo")
    val title: String,
    @SerializedName("capa")
    val thumb: String,
    @SerializedName("preco")
    val price: Double,
    @SerializedName("descricao")
    val description: String
)