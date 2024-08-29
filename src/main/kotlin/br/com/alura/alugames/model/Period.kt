package br.com.alura.alugames.model

import java.time.LocalDate
import java.time.Period

data class Period(
    val inicialDate: LocalDate,
    val finalDate: LocalDate
) {
    val inDays = Period.between(inicialDate, finalDate).days
}