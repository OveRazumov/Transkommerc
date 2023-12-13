package com.overazumov.transkommerc.data

import java.time.format.DateTimeFormatter
import java.util.Locale

object DateTimeFormatter {
    val DATE = DateTimeFormatter.ofPattern("E d MMMM", Locale("ru"))
    val TIME = DateTimeFormatter.ofPattern("HH:mm")
}