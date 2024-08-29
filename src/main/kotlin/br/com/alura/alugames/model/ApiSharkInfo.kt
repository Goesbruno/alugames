package br.com.alura.alugames.model

import com.google.gson.annotations.SerializedName

data class ApiSharkInfo(
    @SerializedName("title")
    val title: String,
    @SerializedName("thumb")
    val thumb: String,
)
