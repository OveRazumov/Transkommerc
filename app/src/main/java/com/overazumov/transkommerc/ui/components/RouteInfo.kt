package com.overazumov.transkommerc.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.overazumov.transkommerc.R
import com.overazumov.transkommerc.data.DateTimeFormatter
import com.overazumov.transkommerc.data.trip.Route
import com.overazumov.transkommerc.ui.screens.home.getRoute
import com.overazumov.transkommerc.ui.theme.TranskommercTheme

@Composable
fun RouteInfo(
    route: Route,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.height(dimensionResource(R.dimen.medium_size))
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxHeight()
        ) {
            Text(route.departureTime.format(DateTimeFormatter.TIME))
            Text(route.arrivalTime.format(DateTimeFormatter.TIME))
        }
        Image(
            painter = painterResource(R.drawable.path),
            contentDescription = null,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        )
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxHeight()
        ) {
            Text(stringResource(route.departureCity))
            Text(stringResource(route.destinationCity))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RouteInfoPreview() {
    TranskommercTheme {
        RouteInfo(getRoute())
    }
}