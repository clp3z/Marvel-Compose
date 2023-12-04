package com.clp3z.marvelcompose.ui.screens.characters

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.clp3z.marvelcompose.repositories.CharactersRepository
import com.clp3z.marvelcompose.repositories.models.Character
import com.clp3z.marvelcompose.ui.MarvelScreen
import com.clp3z.marvelcompose.ui.models.characterPreview
import com.clp3z.marvelcompose.ui.screens.common.MarvelDetailScreen

@Composable
fun CharacterDetailScreen(id: Int) {
    var character by remember { mutableStateOf<Character?>(null) }

    LaunchedEffect(Unit) {
        character = CharactersRepository.getCharacter(id)
    }

    character?.let {
        MarvelDetailScreen(it)
    }
}

@Preview(widthDp = 400, heightDp = 800)
@Composable
private fun CharacterDetailPreview() {
    MarvelScreen {
        MarvelDetailScreen(characterPreview)
    }
}
