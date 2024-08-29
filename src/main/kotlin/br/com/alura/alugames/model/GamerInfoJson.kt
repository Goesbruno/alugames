package br.com.alura.alugames.model

import com.google.gson.annotations.SerializedName

data class GamerInfoJson(
    @SerializedName("nome")
    val name: String,
    val email: String,
    @SerializedName("dataNascimento")
    val birthDate: String,
    @SerializedName("usuario")
    val user: String){



}