package com.overazumov.transkommerc.data.user

import com.overazumov.transkommerc.data.trip.Trip

class Driver(
    name: String,
    phoneNumber: PhoneNumber,
    var surname: String,
    var car: Car
) : User(name, phoneNumber) {

    override fun addTrip(trip: Trip) {
        nextTrips.addLast(trip)
    }

    override fun completeTrip(trip: Trip) {
        completedTrips.addFirst(trip)
    }

    class Car(
        var model: String,
        var color: String,
        var year: Int,
        var passengerSeatsNumber: Int
    )
}