package com.example.adgrid.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val CMPColorScheme = lightColorScheme(
    primary = Purple,
    onPrimary = White,
    secondary = Pink,
    onSecondary = White,
    background = BackgroundGray,
    onBackground = DarkNavy,
    surface = CardWhite,
    onSurface = DarkNavy,
    surfaceVariant = PurpleLight,
    onSurfaceVariant = GrayText
)

@Composable
fun CMPTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = CMPColorScheme,
        typography = CMPTypography,
        content = content
    )
}