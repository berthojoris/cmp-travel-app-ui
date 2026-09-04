package com.example.travelappui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = TravelColors.TealPrimary,
    onPrimary = Color.White,
    primaryContainer = TravelColors.TealLight,
    onPrimaryContainer = TravelColors.TealPrimary,
    secondary = TravelColors.TealMedium,
    onSecondary = Color.White,
    background = TravelColors.Background,
    onBackground = TravelColors.TextPrimary,
    surface = TravelColors.SurfaceWhite,
    onSurface = TravelColors.TextPrimary,
    surfaceVariant = TravelColors.SurfaceElevated,
    onSurfaceVariant = TravelColors.TextSecondary,
    outline = TravelColors.SurfaceBorder
)

@Composable
fun TravelAppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = TravelMaterialTypography,
        content = content
    )
}
