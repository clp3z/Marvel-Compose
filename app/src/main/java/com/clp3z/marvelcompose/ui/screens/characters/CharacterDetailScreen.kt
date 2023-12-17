package com.clp3z.marvelcompose.ui.screens.characters

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.clp3z.marvelcompose.ui.MarvelScreen
import com.clp3z.marvelcompose.ui.models.characterPreview
import com.clp3z.marvelcompose.ui.screens.common.MarvelDetailScreen

@Composable
fun CharacterDetailScreen(viewModel: CharacterDetailViewModel = viewModel()) {

    MarvelDetailScreen(
        isLoading = viewModel.viewState.isLoading,
        item = viewModel.viewState.character,
    )
}

@Preview(widthDp = 400, heightDp = 800)
@Composable
private fun CharacterDetailPreview() {
    MarvelScreen {
        MarvelDetailScreen(
            isLoading = false,
            item = characterPreview
        )
    }
}
