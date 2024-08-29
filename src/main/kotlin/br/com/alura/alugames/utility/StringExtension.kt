package br.com.alura.alugames.utility

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun String.toAgeFormatter(): Int {
    var age = 0
    var period = 0
    val formatting = runCatching {
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

        val birthDate = LocalDate.parse(this, formatter)
        val today = LocalDate.now()
        period = Period.between(birthDate, today).years
    }
    when {
        formatting.isSuccess -> age = period
        formatting.isFailure -> {
            println("Data inválida")
            age = 0
        }
    }
    return age
}