package com.clp3z.marvelcompose.ui.screens.events

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.clp3z.marvelcompose.repository.models.Event
import com.clp3z.marvelcompose.ui.screens.common.MarvelListScreen

@Composable
fun EventsScreen(
    onClick: (Event) -> Unit,
    viewModel: EventsViewModel = viewModel(),
) {

    val viewState by viewModel.viewState.collectAsState()
    MarvelListScreen(
        isLoading = viewState.isLoading,
        items = viewState.events,
        onClick = onClick
    )
}
