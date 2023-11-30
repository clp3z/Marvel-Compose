package com.clp3z.marvelcompose.ui.screens.comics

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.clp3z.marvelcompose.repositories.ComicsRepository
import com.clp3z.marvelcompose.repositories.models.Comic
import com.clp3z.marvelcompose.ui.screens.common.MarvelListScreen

@Composable
fun ComicsScreen(onClick: (Comic) -> Unit) {
    var comics by rememberSaveable { mutableStateOf(emptyList<Comic>()) }

    LaunchedEffect(Unit) {
        comics = ComicsRepository.getComics()
    }

    MarvelListScreen(
        items = comics,
        onClick = onClick
    )
}
