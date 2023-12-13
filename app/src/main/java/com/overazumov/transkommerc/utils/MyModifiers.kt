package com.overazumov.transkommerc.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed

/**
 * A [Modifier] that makes a composable clickable without indication.
 *
 * @param onClick the lambda to be executed when the composable is clicked.
 */
fun Modifier.clickableWithoutIndication(onClick: () -> Unit): Modifier = composed {
    this.then(
        Modifier.clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null,
            onClick = onClick
        )
    )
}