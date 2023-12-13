package com.overazumov.transkommerc.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.overazumov.transkommerc.R
import com.overazumov.transkommerc.ui.screens.AccountScreen
import com.overazumov.transkommerc.ui.screens.DriverInfoScreen
import com.overazumov.transkommerc.ui.screens.MyTripsScreen
import com.overazumov.transkommerc.ui.screens.TripInfoScreen
import com.overazumov.transkommerc.ui.screens.findTrip.FindTripScreen
import com.overazumov.transkommerc.ui.screens.home.getNextTrip

enum class AppScreen(@StringRes val title: Int) {
    FindTrip(R.string.home),
    MyTrips(R.string.home),
    Account(R.string.home),
    TripInfo(R.string.trip),
    DriverInfo(R.string.driver)
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = AppScreen.FindTrip.name,
        modifier = modifier
    ) {
        composable(route = AppScreen.FindTrip.name) {
            FindTripScreen(
                onFindTripButton = { /*TODO*/ }
            )
        }
        composable(route = AppScreen.MyTrips.name) {
            MyTripsScreen(
                onTripCard = { navController.navigate(AppScreen.TripInfo.name) }
            )
        }
        composable(route = AppScreen.Account.name) {
            AccountScreen()
        }
        composable(route = AppScreen.TripInfo.name) {
            TripInfoScreen(
                trip = getNextTrip(),
                onDriverAndCarInfo = { navController.navigate(AppScreen.DriverInfo.name) }
            )
        }
        composable(route = AppScreen.DriverInfo.name) {
            DriverInfoScreen()
        }
    }
}