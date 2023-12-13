package com.overazumov.transkommerc.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.overazumov.transkommerc.R
import com.overazumov.transkommerc.data.user.Driver
import com.overazumov.transkommerc.ui.screens.home.getDriver
import com.overazumov.transkommerc.ui.theme.TranskommercTheme

@Composable
fun DriverInfo(
    driver: Driver,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.medium_padding)),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(driver.imageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(dimensionResource(R.dimen.medium_size))
                .clip(CircleShape)
        )
        Text("${driver.name} ${driver.surname}")
    }
}

@Preview(showBackground = true)
@Composable
private fun DriverInfoPreview() {
    TranskommercTheme {
        DriverInfo(getDriver())
    }
}