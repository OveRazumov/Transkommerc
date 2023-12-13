package com.overazumov.transkommerc.ui.screens.findTrip

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.overazumov.transkommerc.R
import com.overazumov.transkommerc.utils.clickableWithoutIndication
import com.overazumov.transkommerc.ui.theme.TranskommercTheme
import java.time.LocalDate

@Composable
fun FindTripScreen(
    onFindTripButton: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: FindTripViewModel = FindTripViewModel()
) {
    FindTrip(
        departureCity = viewModel.departureCity,
        destinationCity = viewModel.destinationCity,
        date = viewModel.date,
        passengersNumber = viewModel.passengersNumber,
        onDateField = { TODO() },
        onPassengersNumberField = { TODO() },
        onFindTripButton = onFindTripButton,
        modifier = modifier.fillMaxSize()
    )
}

@Composable
private fun FindTrip(
    departureCity: String,
    destinationCity: String,
    date: LocalDate,
    passengersNumber: Int,
    onDateField: () -> Unit,
    onPassengersNumberField: () -> Unit,
    onFindTripButton: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        FindTripCard(
            departureCity = departureCity,
            destinationCity = destinationCity,
            date = date,
            passengersNumber = passengersNumber,
            onDateField = onDateField,
            onPassengersNumberField = onPassengersNumberField,
            onFindTripButton = onFindTripButton,
            modifier = Modifier.padding(dimensionResource(R.dimen.medium_padding))
        )
    }
}


@Composable
private fun FindTripCard(
    departureCity: String,
    destinationCity: String,
    date: LocalDate,
    passengersNumber: Int,
    onDateField: () -> Unit,
    onPassengersNumberField: () -> Unit,
    onFindTripButton: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        ),
        elevation = CardDefaults.cardElevation(dimensionResource(R.dimen.medium_elevation)),
        modifier = modifier
    ) {
        FindTripFields(
            departureCity = departureCity,
            destinationCity = destinationCity,
            date = date,
            passengersNumber = passengersNumber,
            onDateField = onDateField,
            onPassengersNumberField = onPassengersNumberField,
            modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.medium_padding))
        )
        Button(
            onClick = onFindTripButton,
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(dimensionResource(R.dimen.field_height))
        ) {
            Text(stringResource(R.string.find))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun FindTripFields(
    departureCity: String,
    destinationCity: String,
    date: LocalDate,
    passengersNumber: Int,
    onDateField: () -> Unit,
    onPassengersNumberField: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        TextField(
            value = departureCity,
            onValueChange = { TODO() },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = null
                )
            },
            placeholder = { Text(stringResource(R.string.placeholder_wherefrom)) },
            colors = TextFieldDefaults.textFieldColors(containerColor = Color.Transparent),
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = destinationCity,
            onValueChange = { TODO() },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = null
                )
            },
            placeholder = { Text(stringResource(R.string.placeholder_whereto)) },
            colors = TextFieldDefaults.textFieldColors(containerColor = Color.Transparent),
            modifier = Modifier.fillMaxWidth(),
        )
        CalendarAndPersonNumberFields(
            date = date,
            passengersNumber = passengersNumber,
            onDateField = onDateField,
            onPassengersNumberField = onPassengersNumberField
        )
    }
}

@Composable
private fun CalendarAndPersonNumberFields(
    date: LocalDate,
    passengersNumber: Int,
    onDateField: () -> Unit,
    onPassengersNumberField: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        CustomField(
            fieldValue = date.toString(),
            imageVector = Icons.Default.DateRange,
            onClick = onDateField,
            modifier = Modifier.weight(7f)
        )
        Divider(
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier
                .width(1.dp)
                .height(dimensionResource(R.dimen.small_size))
        )
        CustomField(
            fieldValue = passengersNumber.toString(),
            imageVector = Icons.Default.Person,
            onClick = onPassengersNumberField,
            modifier = Modifier.weight(3f)
        )
    }
}

@Composable
private fun CustomField(
    fieldValue: String,
    imageVector: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .height(dimensionResource(R.dimen.field_height))
            .clickableWithoutIndication { onClick }
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = null,
            modifier = Modifier.padding(12.dp)
        )
        Text(
            text = fieldValue,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun FindTripScreenPreview() {
    TranskommercTheme {
        FindTripScreen(
            onFindTripButton = { }
        )
    }
}

@Preview
@Composable
private fun FindTripCardPreview() {
    TranskommercTheme {
        FindTripCard(
            departureCity = "",
            destinationCity = "",
            date = getDate(),
            passengersNumber = getPassengersNumber(),
            onDateField = { },
            onPassengersNumberField = { },
            onFindTripButton = { }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun FindTripFieldsPreview() {
    TranskommercTheme {
        FindTripFields(
            departureCity = "",
            destinationCity = "",
            date = getDate(),
            passengersNumber = getPassengersNumber(),
            onDateField = { },
            onPassengersNumberField = { }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CalendarAndPersonNumberFieldsPreview() {
    TranskommercTheme {
        CalendarAndPersonNumberFields(
            date = LocalDate.now(),
            passengersNumber = 3,
            onDateField = { },
            onPassengersNumberField = { }
        )
    }
}


