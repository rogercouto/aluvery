package br.com.alura.aluvery.extensions

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

fun BigDecimal.toBrazilianCurrency(): String = NumberFormat
    .getCurrencyInstance(Locale("pt", "br"))
    .format(this)