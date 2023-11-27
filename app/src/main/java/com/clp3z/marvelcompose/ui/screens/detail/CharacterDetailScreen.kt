package com.clp3z.marvelcompose.ui.screens.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Collections
import androidx.compose.material.icons.filled.Event
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.clp3z.marvelcompose.MarvelApplication
import com.clp3z.marvelcompose.repositories.CharactersRepository
import com.clp3z.marvelcompose.ui.models.Character
import com.clp3z.marvelcompose.ui.models.Reference
import com.clp3z.marvelcompose.ui.models.characterPreview
import com.clp3z.marvelcompose.ui.views.CustomListItem

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
    LazyColumn{
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

@Composable
fun Header(character: Character, modifier: Modifier = Modifier) {
    Column {
        AsyncImage(
            model = character.thumbnail,
            contentDescription = character.description,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .fillMaxSize()
                .aspectRatio(1f)
                .background(Color.LightGray)
        )
        Spacer(modifier = modifier.height(8.dp))
        Text(
            text = character.name,
            style = MaterialTheme.typography.h5,
            maxLines = 2,
            modifier = modifier
                .padding(16.dp, 0.dp)
                .align(CenterHorizontally)
        )
        if (character.description.isNotEmpty()) {
            Spacer(modifier = modifier.height(16.dp))
            Text(
                text = character.description,
                style = MaterialTheme.typography.body1,
                modifier = modifier.padding(16.dp, 0.dp)
            )
        }
        Spacer(modifier = modifier.height(16.dp))
    }
}

fun LazyListScope.section(
    name: String,
    icon: ImageVector,
    items: List<Reference>
) {
    if (items.isEmpty()) return
    item {
        Text(
            text = name,
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 8.dp)
        )
    }
    items(items) { reference ->
        CustomListItem(
            name = reference.name,
            icon = icon,
            modifier = Modifier.padding(16.dp, 8.dp)
        )
    }
    item {
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Preview(widthDp = 400, heightDp = 800)
@Composable
fun CharacterDetailPreview() {
    MarvelApplication {
        CharacterDetailScreen(character = characterPreview)
    }
}