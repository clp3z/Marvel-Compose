package com.clp3z.marvelcompose.ui.screens.characters

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import arrow.core.right
import com.clp3z.marvelcompose.ui.MarvelScreen
import com.clp3z.marvelcompose.ui.models.characterPreview
import com.clp3z.marvelcompose.ui.screens.common.MarvelDetailScreen

@Composable
fun CharacterDetailScreen(viewModel: CharacterDetailViewModel = viewModel()) {
    val viewState by viewModel.viewState.collectAsState()
    MarvelDetailScreen(
        isLoading = viewState.isLoading,
        item = viewState.character,
    )
}

@Preview(widthDp = 400, heightDp = 800)
@Composable
private fun CharacterDetailPreview() {
    MarvelScreen {
        MarvelDetailScreen(
            isLoading = false,
            item = characterPreview.right()
        )
    }
}
