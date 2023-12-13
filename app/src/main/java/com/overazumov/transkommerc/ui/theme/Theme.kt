package com.overazumov.transkommerc.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Purple40,
    onPrimary = Color.White,
    secondary = Color.White,
    tertiary = Color.DarkGray,
    surface = Color.White,
    onSurface = Color.DarkGray,
    background = Color.White,
    onBackground = Color.DarkGray
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    onPrimary = Color.White,
    secondary = Color.Gray,
    tertiary = Color.LightGray,
    surface = Color.White,
    onSurface = Color.DarkGray,
    onSurfaceVariant = Color.DarkGray,
    background = Color.White,
    onBackground = Color.Black,
    surfaceTint = Color.White
)

@Composable
fun TranskommercTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme,
        shapes = Shapes,
        typography = Typography,
        content = content
    )
}