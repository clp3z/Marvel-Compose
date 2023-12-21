package com.clp3z.marvelcompose.ui.screens.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import arrow.core.right
import com.clp3z.marvelcompose.repository.models.MarvelItem
import com.clp3z.marvelcompose.repository.models.Result
import com.clp3z.marvelcompose.ui.MarvelScreen
import com.clp3z.marvelcompose.ui.models.characters

@Composable
fun <T : MarvelItem> MarvelListScreen(
    isLoading: Boolean,
    items: Result<List<T>>,
    onClick: (T) -> Unit
) {
    items.fold(
        ifLeft = { ErrorMessage(it) },
        ifRight = {
            MarvelList(
                isLoading = isLoading,
                items = it,
                onClick = onClick
            )
        }
    )
}

@Preview(widthDp = 400, heightDp = 800)
@Composable
private fun MarvelListScreenPreview() {
    MarvelScreen {
        MarvelListScreen(
            isLoading = false,
            items = characters.right(),
            onClick = {}
        )
    }
}
