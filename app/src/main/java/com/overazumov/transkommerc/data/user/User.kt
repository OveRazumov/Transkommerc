package com.overazumov.transkommerc.data.user

import androidx.annotation.DrawableRes
import com.overazumov.transkommerc.R
import com.overazumov.transkommerc.data.trip.Trip

abstract class User(
    var name: String,
    var phoneNumber: PhoneNumber,
    @DrawableRes var imageRes: Int = R.drawable.spidey
) {
    var nextTrips = ArrayDeque<Trip>()
    val completedTrips = ArrayDeque<Trip>()

    abstract fun addTrip(trip: Trip)

    abstract fun completeTrip(trip: Trip)

    class PhoneNumber(private val number: String) {
        override fun toString(): String {
            return number
        }
    }
}

