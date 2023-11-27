package com.clp3z.marvelcompose.ui.screens.detail

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.tooling.preview.Preview
import com.clp3z.marvelcompose.MarvelApplication
import com.clp3z.marvelcompose.repositories.CharactersRepository
import com.clp3z.marvelcompose.ui.models.Character
import com.clp3z.marvelcompose.ui.models.characterPreview
import com.clp3z.marvelcompose.ui.screens.detail.views.CharacterSections
import com.clp3z.marvelcompose.ui.screens.detail.views.getOverflowMenuItems
import com.clp3z.marvelcompose.ui.views.AppBarOverflowMenu
import com.clp3z.marvelcompose.ui.views.BackNavigationAction

@Composable
fun CharacterDetailScreen(id: Int, onUpClick: () -> Unit) {
    var character by remember { mutableStateOf<Character?>(null) }

    LaunchedEffect(Unit) {
        character = CharactersRepository.getCharacter(id)
    }

    character?.let {
        ScreenLayout(it, onUpClick)
    }
}

@Composable
private fun ScreenLayout(
    character: Character,
    onUpClick: () -> Unit
) {
    val menuItems = getOverflowMenuItems(character, LocalUriHandler.current)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = character.name) },
                navigationIcon = { BackNavigationAction(onUpClick) },
                actions = { AppBarOverflowMenu(menuItems) }
            )
        }
    ) {
        CharacterSections(
            character = character,
            modifier = Modifier.padding(it)
        )
    }
}

@Preview(widthDp = 400, heightDp = 800)
@Composable
private fun CharacterDetailPreview() {
    MarvelApplication {
        ScreenLayout(characterPreview, onUpClick = {})
    }
}