package com.clp3z.marvelcompose.ui.screens.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.clp3z.marvelcompose.repositories.CharactersRepository
import com.clp3z.marvelcompose.ui.models.Character

@Composable
fun CharacterDetailScreen(id: Int) {
    var character by remember { mutableStateOf<Character?>(null) }

    LaunchedEffect(Unit) {
        character = CharactersRepository.getCharacter(id)
    }

    character?.let {
        CharacterDetailScreen(it)
    }
}

@Composable
fun CharacterDetailScreen(character: Character) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        Text(text = "Character: ${character.name}")
    }
}

@Preview
@Composable
fun CharacterDetailPreview() {
    CharacterDetailScreen(1)
}