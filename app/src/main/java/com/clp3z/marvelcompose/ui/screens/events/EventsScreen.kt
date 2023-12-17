package com.clp3z.marvelcompose.ui.screens.events

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.clp3z.marvelcompose.repositories.models.Event
import com.clp3z.marvelcompose.ui.screens.common.MarvelListScreen

@Composable
fun EventsScreen(
    onClick: (Event) -> Unit,
    viewModel: EventsViewModel = viewModel(),
) {

    MarvelListScreen(
        isLoading = viewModel.viewState.isLoading,
        items = viewModel.viewState.events,
        onClick = onClick
    )
}
