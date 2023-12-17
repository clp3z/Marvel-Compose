package com.clp3z.marvelcompose.ui.screens.events

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.clp3z.marvelcompose.ui.models.eventPreview
import com.clp3z.marvelcompose.ui.screens.common.MarvelDetailScreen

@Composable
fun EventDetailScreen(viewModel: EventDetailViewModel = viewModel()) {

    MarvelDetailScreen(
        isLoading = viewModel.viewState.isLoading,
        item = viewModel.viewState.event
    )
}

@Preview(widthDp = 400, heightDp = 800)
@Composable
fun EventDetailScreenPreview() {
    MarvelDetailScreen(
        isLoading = false,
        item = eventPreview
    )
}
