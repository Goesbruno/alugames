package br.com.alura.alugames.model

data class GameInfo(val info: ApiSharkInfo) {
    override fun toString(): String {
        return info.toString()
    }
}