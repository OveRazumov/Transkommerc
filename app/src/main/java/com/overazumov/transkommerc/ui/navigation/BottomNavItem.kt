package com.overazumov.transkommerc.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DirectionsCar
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector

import com.overazumov.transkommerc.R

sealed class BottomNavItem(
    @StringRes val title: Int,
    val icon: ImageVector,
    val appScreen: AppScreen
) {
    object FindTripScreen: BottomNavItem(
        title = R.string.find_trip,
        icon = Icons.Outlined.Search,
        appScreen = AppScreen.FindTrip
    )
    object MyTripsScreen: BottomNavItem(
        title = R.string.my_trips,
        icon = Icons.Outlined.DirectionsCar,
        appScreen = AppScreen.MyTrips
    )
    object AccountScreen: BottomNavItem(
        title = R.string.account,
        icon = Icons.Outlined.Person,
        appScreen = AppScreen.Account
    )
}

val bottomNavItems = listOf(
    BottomNavItem.MyTripsScreen,
    BottomNavItem.FindTripScreen,
    BottomNavItem.AccountScreen
)
