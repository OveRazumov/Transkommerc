package com.overazumov.transkommerc.ui.screens.findTrip

import androidx.lifecycle.ViewModel
import java.time.LocalDate

class FindTripViewModel : ViewModel() {
    private val _departureCity: String = ""
    val departureCity: String
        get() = _departureCity

    private val _destinationCity: String = ""
    val destinationCity: String
        get() = _destinationCity

    private val _date: LocalDate = getDate()
    val date: LocalDate
        get() = _date

    private val _passengersNumber: Int = getPassengersNumber()
    val passengersNumber: Int
        get() = _passengersNumber
}

fun getDepartureCity() = "Рудный"

fun getDestinationCity() = "Челябинск"

fun getDate() = LocalDate.now().plusDays(1)

fun getPassengersNumber() = 1
