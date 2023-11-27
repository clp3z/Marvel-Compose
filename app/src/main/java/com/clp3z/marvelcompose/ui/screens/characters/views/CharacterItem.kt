package com.clp3z.marvelcompose.ui.screens.characters.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.clp3z.marvelcompose.ui.models.Character

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
