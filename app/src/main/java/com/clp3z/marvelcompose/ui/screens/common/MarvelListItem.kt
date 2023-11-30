package com.clp3z.marvelcompose.ui.screens.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.clp3z.marvelcompose.repositories.models.MarvelItem

@Composable
fun MarvelListItem(marvelItem: MarvelItem, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(8.dp)
    ) {
        Card {
            AsyncImage(
                model = marvelItem.thumbnail,
                contentScale = ContentScale.Crop,
                contentDescription = marvelItem.description,
                modifier = modifier
                    .fillMaxSize()
                    .aspectRatio(1f)
                    .background(Color.LightGray)
            )
        }
        Box(
            modifier = modifier
                .padding(0.dp, 4.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = marvelItem.name,
                style = MaterialTheme.typography.h6,
                maxLines = 2
            )
        }
    }
}
