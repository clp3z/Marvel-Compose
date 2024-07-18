package com.clp3z.marvelcompose.ui.theme

import android.app.Activity
import android.graphics.Color.toArgb
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView

private val DarkColorPalette = darkColors(
    primary = Marvel_Red,
    primaryVariant = Marvel_Red_Dark,
    secondary = Marvel_Blue
)

private val LightColorPalette = lightColors(
    primary = Marvel_Red,
    primaryVariant = Marvel_Red_Dark,
    secondary = Marvel_Blue
)

@Composable
fun MarvelComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = Marvel_Red_Dark.toArgb()
        }
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}