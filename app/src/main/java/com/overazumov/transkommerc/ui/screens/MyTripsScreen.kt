package com.overazumov.transkommerc.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.overazumov.transkommerc.R
import com.overazumov.transkommerc.data.trip.Trip
import com.overazumov.transkommerc.ui.screens.home.HomeViewModel
import com.overazumov.transkommerc.ui.components.TripCard
import com.overazumov.transkommerc.ui.screens.home.getPassenger
import com.overazumov.transkommerc.ui.theme.TranskommercTheme

@Composable
fun MyTripsScreen(
    onTripCard: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = HomeViewModel()
) {
    MyTripsList(
        nextTrips = viewModel.user.nextTrips,
        completedTrips = viewModel.user.completedTrips,
        onTripCard = onTripCard,
        modifier = modifier
    )
}

@Composable
private fun MyTripsList(
    nextTrips: List<Trip>,
    completedTrips: List<Trip>,
    onTripCard: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        contentPadding = PaddingValues(dimensionResource(R.dimen.medium_padding)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.medium_padding)),
        modifier = modifier
    ) {
        item {
            Text(
                text = stringResource(R.string.booked_trips),
                style = MaterialTheme.typography.titleSmall
            )
        }
        items(nextTrips) { trip ->
            TripCard(
                trip = trip,
                onTripCard = onTripCard
            )
        }
        item {
            Text(
                text = stringResource(R.string.completed_trips),
                style = MaterialTheme.typography.titleSmall
            )
        }
        items(completedTrips) { trip ->
            TripCard(
                trip = trip,
                onTripCard = onTripCard
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MyTripsListPreview() {
    TranskommercTheme {
        MyTripsList(
            nextTrips = getPassenger().nextTrips,
            completedTrips = getPassenger().completedTrips,
            onTripCard = { }
        )
    }
}



