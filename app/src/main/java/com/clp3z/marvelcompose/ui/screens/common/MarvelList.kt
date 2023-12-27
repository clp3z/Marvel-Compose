package com.clp3z.marvelcompose.ui.screens.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.clp3z.marvelcompose.repository.models.MarvelItem


@Composable
fun <T : MarvelItem> MarvelList(
    isLoading: Boolean,
    items: List<T>,
    onItemClick: (T) -> Unit,
    onItemMoreClick: (T) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (isLoading) CircularProgressIndicator()

        if (items.isNotEmpty()) {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(180.dp),
                contentPadding = PaddingValues(8.dp),
                modifier = modifier.align(Alignment.TopCenter)
            ) {
                items(items) {
                    MarvelListItem(
                        marvelItem = it,
                        modifier = modifier.clickable { onItemClick(it) },
                        onItemMoreClicked = onItemMoreClick
                    )
                }
            }
        }
    }
}
