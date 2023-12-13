package com.overazumov.transkommerc.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.overazumov.transkommerc.R
import com.overazumov.transkommerc.ui.screens.AccountCard
import com.overazumov.transkommerc.ui.screens.home.HomeViewModel
import com.overazumov.transkommerc.ui.screens.home.getDriver

@Composable
fun DriverInfoScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = HomeViewModel()
) {
    AccountCard(
        user = getDriver(),
        modifier = modifier.padding(dimensionResource(R.dimen.medium_padding))
    )
}