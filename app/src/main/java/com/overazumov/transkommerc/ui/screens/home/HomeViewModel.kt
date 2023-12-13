package com.overazumov.transkommerc.ui.screens.home

import androidx.lifecycle.ViewModel
import com.overazumov.transkommerc.R
import com.overazumov.transkommerc.data.trip.Route
import com.overazumov.transkommerc.data.trip.Trip
import com.overazumov.transkommerc.data.user.Driver
import com.overazumov.transkommerc.data.user.Passenger
import com.overazumov.transkommerc.data.user.User
import java.time.LocalDate
import java.time.LocalTime

class HomeViewModel : ViewModel() {
    private val _user = getPassenger()
    val user: User
        get() = _user


}

fun getPassenger() = Passenger(
    name = "Никита",
    phoneNumber = User.PhoneNumber("+7(981)113-46-16")
).apply {
    addTrip(getNextTrip())
    completeTrip(getCompletedTrip())
    completeTrip(getCompletedTrip())
}

fun getCar() = Driver.Car(
    model = "Mazda 3",
    color = "Черный",
    year = 2008,
    passengerSeatsNumber = 4
)

fun getDriver() = Driver(
    name = "Никита",
    surname = "Разумов",
    phoneNumber = User.PhoneNumber("+7(981)113-46-16"),
    car = getCar()
)

fun getRoute() = Route(
    departureCity = R.string.rudny_city,
    destinationCity = R.string.chelyabinsk_city,
    departureTime = LocalTime.now(),
    arrivalTime = LocalTime.now().plusHours(6),
    price = 2000
)

fun getNextTrip() = Trip(
    isCompleted = false,
    route = getRoute(),
    driver = getDriver(),
    departureDate = LocalDate.now()
)

fun getCompletedTrip() = Trip(
    isCompleted = true,
    route = getRoute(),
    driver = getDriver(),
    departureDate = LocalDate.now()
)
