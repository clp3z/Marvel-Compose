package com.clp3z.marvelcompose.ui.screens.comics

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.clp3z.marvelcompose.repositories.ComicsRepository
import com.clp3z.marvelcompose.repositories.models.Comic
import com.clp3z.marvelcompose.ui.MarvelScreen
import com.clp3z.marvelcompose.ui.models.comicPreview
import com.clp3z.marvelcompose.ui.screens.common.MarvelDetailScreen

@Composable
fun ComicDetailScreen(id: Int, onUpClick: () -> Unit) {
    var comic by remember { mutableStateOf<Comic?>(null) }

    LaunchedEffect(Unit) {
        comic = ComicsRepository.getComic(id)
    }

    comic?.let {
        MarvelDetailScreen(it, onUpClick)
    }
}

@Preview(widthDp = 400, heightDp = 800)
@Composable
private fun ComicDetailScreenPreview() {
    MarvelScreen {
        MarvelDetailScreen(comicPreview, onUpClick = {})
    }
}
