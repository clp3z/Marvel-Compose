package com.clp3z.marvelcompose

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.clp3z.marvelcompose.ui.theme.MarvelComposeTheme

@Composable
fun MarvelApplication(content: @Composable () -> Unit) {
    MarvelComposeTheme {
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}