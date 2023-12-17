package com.clp3z.marvelcompose.ui.screens.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.clp3z.marvelcompose.repositories.models.MarvelItem
import com.clp3z.marvelcompose.ui.MarvelScreen
import com.clp3z.marvelcompose.ui.models.characters

@Composable
fun <T : MarvelItem> MarvelListScreen(
    isLoading: Boolean,
    items: List<T>,
    onClick: (T) -> Unit
) {
    MarvelList(
        isLoading = isLoading,
        items = items,
        onClick = onClick
    )
}

@Preview(widthDp = 400, heightDp = 800)
@Composable
private fun MarvelListScreenPreview() {
    MarvelScreen {
        MarvelListScreen(
            isLoading = false,
            items = characters,
            onClick = {}
        )
    }
}
