package com.overazumov.transkommerc.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.overazumov.transkommerc.R
import com.overazumov.transkommerc.data.trip.Trip
import com.overazumov.transkommerc.ui.screens.home.getNextTrip
import com.overazumov.transkommerc.ui.theme.TranskommercTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TripCard(
    trip: Trip,
    onTripCard: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onTripCard,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        ),
        elevation = CardDefaults.cardElevation(dimensionResource(R.dimen.medium_elevation)),
        modifier = modifier
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.medium_padding)),
            modifier = Modifier.padding(dimensionResource(R.dimen.medium_padding))
        ) {
            RouteInfo(trip.route)
            HorizontalDivider()
            DriverInfo(trip.driver)
        }
    }
}

@Preview
@Composable
private fun TripCardPreview() {
    TranskommercTheme {
        TripCard(
            trip = getNextTrip(),
            onTripCard = { }
        )
    }
}