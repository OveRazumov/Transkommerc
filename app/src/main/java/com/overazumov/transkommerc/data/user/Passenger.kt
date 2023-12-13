package com.overazumov.transkommerc.data.user

import com.overazumov.transkommerc.data.trip.Trip

class Passenger(
    name: String,
    phoneNumber: PhoneNumber
) : User(name, phoneNumber) {
    var departureAddress: Address? = null
    var destinationAddress: Address? = null

    override fun addTrip(trip: Trip) {
        nextTrips.addLast(trip)
    }

    override fun completeTrip(trip: Trip) {
        completedTrips.addFirst(trip)
    }

    data class Address(
        val city: String,
        val street: String,
        val houseNumber: Int,
        val entranceNumber: Int
    )
}