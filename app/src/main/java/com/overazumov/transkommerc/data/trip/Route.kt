package com.overazumov.transkommerc.data.trip

import androidx.annotation.StringRes
import java.time.LocalDateTime
import java.time.LocalTime

data class Route(
    @StringRes val departureCity: Int,
    @StringRes val destinationCity: Int,
    val departureTime: LocalTime,
    val arrivalTime: LocalTime,
    val price: Int
)