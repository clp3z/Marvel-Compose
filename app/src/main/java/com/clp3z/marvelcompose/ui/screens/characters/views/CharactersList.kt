package com.clp3z.marvelcompose.ui.screens.characters.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.clp3z.marvelcompose.repositories.models.Character

@Composable
fun CharactersList(
    characters: List<Character>,
    onClick: (Character) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(180.dp),
        contentPadding = PaddingValues(8.dp),
        modifier = modifier.fillMaxSize()
    ) {
        items(characters) {
            CharacterItem(
                character = it,
                modifier = modifier.clickable { onClick(it) }
            )
        }
    }
}
