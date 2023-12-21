package com.clp3z.marvelcompose.ui.screens.characters

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.clp3z.marvelcompose.repository.models.Character
import com.clp3z.marvelcompose.ui.screens.common.MarvelListScreen

@Composable
fun CharactersScreen(
    onClick: (Character) -> Unit,
    viewModel: CharactersViewModel = viewModel(),
) {
    val viewState by viewModel.viewState.collectAsState()
    MarvelListScreen(
        isLoading = viewState.isLoading,
        items = viewState.characters,
        onClick = onClick
    )
}
