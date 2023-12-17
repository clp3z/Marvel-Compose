package com.clp3z.marvelcompose.ui.screens.comics

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.clp3z.marvelcompose.ui.MarvelScreen
import com.clp3z.marvelcompose.ui.models.comicPreview
import com.clp3z.marvelcompose.ui.screens.common.MarvelDetailScreen

@Composable
fun ComicDetailScreen(viewModel: ComicDetailViewModel = viewModel()) {

    MarvelDetailScreen(
        isLoading = viewModel.viewState.isLoading,
        item = viewModel.viewState.comic
    )
}

@Preview(widthDp = 400, heightDp = 800)
@Composable
private fun ComicDetailScreenPreview() {
    MarvelScreen {
        MarvelDetailScreen(
            isLoading = false,
            item = comicPreview
        )
    }
}
