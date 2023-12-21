package com.clp3z.marvelcompose.ui.screens.events

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import arrow.core.right
import com.clp3z.marvelcompose.ui.models.eventPreview
import com.clp3z.marvelcompose.ui.screens.common.MarvelDetailScreen

@Composable
fun EventDetailScreen(viewModel: EventDetailViewModel = viewModel()) {

    val viewState by viewModel.viewState.collectAsState()
    MarvelDetailScreen(
        isLoading = viewState.isLoading,
        item = viewState.event
    )
}

@Preview(widthDp = 400, heightDp = 800)
@Composable
fun EventDetailScreenPreview() {
    MarvelDetailScreen(
        isLoading = false,
        item = eventPreview.right()
    )
}
