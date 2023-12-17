package com.clp3z.marvelcompose.ui.screens.characters

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.clp3z.marvelcompose.repositories.models.Character
import com.clp3z.marvelcompose.ui.screens.common.MarvelListScreen

@Composable
fun CharactersScreen(
    onClick: (Character) -> Unit,
    viewModel: CharactersViewModel = viewModel(),
) {

    MarvelListScreen(
        isLoading = viewModel.viewState.isLoading,
        items = viewModel.viewState.characters,
        onClick = onClick
    )
}
