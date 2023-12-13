package com.overazumov.transkommerc

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.overazumov.transkommerc.ui.screens.home.HomeScreen

@Composable
fun TranskommercApp() {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
    ) {
        HomeScreen()
    }
}