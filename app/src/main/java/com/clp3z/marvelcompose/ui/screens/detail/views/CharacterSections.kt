package com.clp3z.marvelcompose.ui.screens.detail.views

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Collections
import androidx.compose.material.icons.filled.Event
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.clp3z.marvelcompose.ui.models.Character

@Composable
fun CharacterSections(character: Character, modifier: Modifier = Modifier) {
    LazyColumn (modifier = modifier) {
        item {
            Header(character)
        }
        section(
            name = "Series",
            icon = Icons.Default.Collections,
            items = character.series
        )
        section(
            name = "Events",
            icon = Icons.Default.Event,
            items = character.events
        )
        section(
            name = "Comics",
            icon = Icons.Default.Book ,
            items = character.comics
        )
        section(
            name = "Stories",
            icon = Icons.Filled.Book,
            items = character.stories
        )
    }
}