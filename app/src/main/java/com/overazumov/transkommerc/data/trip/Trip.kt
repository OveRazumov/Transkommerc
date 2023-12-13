package com.overazumov.transkommerc.data.trip

import com.overazumov.transkommerc.data.user.Driver
import com.overazumov.transkommerc.data.user.Passenger
import java.time.LocalDate
import java.time.LocalDateTime

class Trip(
    var isCompleted: Boolean,
    val driver: Driver,
    val route: Route,
    val departureDate: LocalDate
) {
    private val passengers = mutableListOf<Passenger>()

    fun addPassenger(passenger: Passenger) {
        passengers.add(passenger)
        passenger.addTrip(this)
    }
}