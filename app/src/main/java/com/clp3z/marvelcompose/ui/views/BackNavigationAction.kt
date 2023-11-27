package com.clp3z.marvelcompose.ui.views

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable

@Composable
fun BackNavigationAction(onUpClick: () -> Unit) {
    AppBarAction(
        imageVector = Icons.Default.ArrowBack,
        contentDescription = "Go back to main screen",
        onClick = { onUpClick() }
    )
}