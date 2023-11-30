package com.clp3z.marvelcompose.ui.screens.characters

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.clp3z.marvelcompose.repositories.CharactersRepository
import com.clp3z.marvelcompose.repositories.models.Character
import com.clp3z.marvelcompose.ui.screens.common.MarvelListScreen

@Composable
fun CharactersScreen(onClick: (Character) -> Unit) {
    var characters by rememberSaveable { mutableStateOf(emptyList<Character>()) }

    LaunchedEffect(Unit) {
        characters = CharactersRepository.getCharacters()
    }

    MarvelListScreen(
        items = characters,
        onClick = onClick
    )
}
