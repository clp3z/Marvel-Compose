package com.clp3z.marvelcompose.ui.screens.characters

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.clp3z.marvelcompose.MarvelApplication
import com.clp3z.marvelcompose.R
import com.clp3z.marvelcompose.repositories.CharactersRepository
import com.clp3z.marvelcompose.ui.models.Character
import com.clp3z.marvelcompose.ui.models.characters
import com.clp3z.marvelcompose.ui.screens.characters.views.CharactersList

@Composable
fun CharactersScreen(onClick: (Character) -> Unit) {
    var characters by rememberSaveable { mutableStateOf(emptyList<Character>()) }

    LaunchedEffect(Unit) {
        characters = CharactersRepository.getCharacters()
    }

    ScreenLayout(
        characters = characters,
        onClick = onClick
    )
}

@Composable
private fun ScreenLayout(
    characters: List<Character>,
    onClick: (Character) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.app_name))
                }
            )
        }
    ) {
        Column {
            CharactersList(
                characters = characters,
                onClick = onClick,
                modifier = Modifier.padding(it)
            )
        }
    }
}

@Preview(widthDp = 400, heightDp = 800)
@Composable
private fun CharactersScreenPreview() {
    MarvelApplication {
        ScreenLayout(
            characters = characters,
            onClick = {}
        )
    }
}
