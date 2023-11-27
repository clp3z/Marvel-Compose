package com.clp3z.marvelcompose.ui.screens.characters

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.clp3z.marvelcompose.repositories.CharactersRepository
import com.clp3z.marvelcompose.ui.models.Character

@Composable
fun CharactersScreen(onClick: (Character) -> Unit) {
    var characters by rememberSaveable { mutableStateOf(emptyList<Character>()) }

    LaunchedEffect(Unit) {
        characters = CharactersRepository.getCharacters()
    }

    CharactersList(
        characters = characters,
        onClick = onClick
    )
}

@Composable
fun CharactersList(characters: List<Character>, onClick: (Character) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(180.dp),
        contentPadding = PaddingValues(8.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(characters) {
            CharacterItem(
                character = it,
                modifier = Modifier.clickable { onClick(it) }
            )
        }
    }
}

@Composable
fun CharacterItem(character: Character, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(8.dp)) {
        Card {
            AsyncImage(
                model = character.thumbnail,
                contentDescription = character.description,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .fillMaxSize()
                    .aspectRatio(1f)
                    .background(Color.LightGray)
            )
        }
        Text(
            text = character.name,
            style = MaterialTheme.typography.h6,
            maxLines = 2,
            modifier = modifier.padding(0.dp, 4.dp)
        )
    }
}
