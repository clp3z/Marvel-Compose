package com.clp3z.marvelcompose.ui.views

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun AppBarAction(
    imageVector: ImageVector,
    onClick: () -> Unit,
    contentDescription: String? = null
) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = imageVector,
            contentDescription = contentDescription
        )
    }
}