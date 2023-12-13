package com.overazumov.transkommerc.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import com.overazumov.transkommerc.R

@Composable
fun HorizontalDivider(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.tertiary
) {
    Divider(
        color = color,
        modifier = modifier.fillMaxWidth()
    )
}