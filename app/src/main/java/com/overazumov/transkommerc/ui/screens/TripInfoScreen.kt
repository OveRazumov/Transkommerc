package com.overazumov.transkommerc.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.overazumov.transkommerc.R
import com.overazumov.transkommerc.data.DateTimeFormatter
import com.overazumov.transkommerc.data.trip.Route
import com.overazumov.transkommerc.data.trip.Trip
import com.overazumov.transkommerc.data.user.Driver
import com.overazumov.transkommerc.ui.components.DriverInfo
import com.overazumov.transkommerc.ui.components.HorizontalDivider
import com.overazumov.transkommerc.ui.components.RouteInfo
import com.overazumov.transkommerc.ui.screens.home.getCar
import com.overazumov.transkommerc.ui.screens.home.getDriver
import com.overazumov.transkommerc.ui.screens.home.getRoute
import com.overazumov.transkommerc.ui.screens.home.getNextTrip
import com.overazumov.transkommerc.ui.theme.TranskommercTheme
import com.overazumov.transkommerc.utils.clickableWithoutIndication
import java.time.LocalDate

@Composable
fun TripInfoScreen(
    trip: Trip,
    onDriverAndCarInfo: () -> Unit,
    modifier: Modifier = Modifier
) {
    TripInfo(
        trip = trip,
        onDriverAndCarInfo = onDriverAndCarInfo,
        modifier = modifier
    )
}

@Composable
fun TripInfo(
    trip: Trip,
    onDriverAndCarInfo: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.medium_padding)),
        modifier = modifier.padding(dimensionResource(R.dimen.medium_padding))
    ) {
        DateAndRouteInfo(
            departureDate = trip.departureDate,
            route = trip.route
        )
        DriverAndCarInfo(
            onClick = onDriverAndCarInfo,
            driver = trip.driver
        )
        if (!trip.isCompleted) {
            PriceInfo(
                price = trip.route.price,
                passengersNumber = 2
            )
        }
    }
}

@Composable
private fun DateAndRouteInfo(
    departureDate: LocalDate,
    route: Route,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.medium_padding)),
        modifier = modifier
    ) {
        Text(
            text = departureDate.format(DateTimeFormatter.DATE),
            style = MaterialTheme.typography.titleLarge
        )
        RouteInfo(route)
        HorizontalDivider()
    }
}

@Composable
private fun DriverAndCarInfo(
    driver: Driver,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.medium_padding)),
        modifier = modifier.clickableWithoutIndication { onClick() }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.medium_padding)),
            modifier = modifier
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.medium_padding)),
                modifier = Modifier.weight(1f)
            ) {
                DriverInfo(driver)
                CarInfo(driver.car)
            }
            Icon(
                imageVector = Icons.Default.ArrowForwardIos,
                contentDescription = stringResource(R.string.driver),
                tint = MaterialTheme.colorScheme.secondary
            )
        }
        HorizontalDivider()
    }
}

@Composable
fun PriceInfo(
    price: Int,
    passengersNumber: Int,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.medium_padding)),
        modifier = modifier
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Всего за $passengersNumber пассажиров",
            )
            Text(
                text = "${price * passengersNumber} Р"
            )
        }
        HorizontalDivider()
    }
}

@Composable
private fun CarInfo(
    car: Driver.Car,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        Text(
            text = car.model,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = car.color
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TripInfoPreview() {
    TranskommercTheme {
        TripInfo(
            onDriverAndCarInfo = { },
            trip = getNextTrip()
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DateAndRouteInfoPreview() {
    TranskommercTheme {
        DateAndRouteInfo(
            departureDate = LocalDate.now(),
            route = getRoute()
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DriverAndCarInfoPreview() {
    TranskommercTheme {
        DriverAndCarInfo(
            driver = getDriver(),
            onClick = { }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PriceInfoPreview() {
    TranskommercTheme {
        PriceInfo(
            price = 2000,
            passengersNumber = 3
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CarInfoPreview() {
    TranskommercTheme {
        CarInfo(getCar())
    }
}