package com.clp3z.marvelcompose.ui.screens.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.clp3z.marvelcompose.repositories.models.MarvelItem

@Composable
fun Header(marvelItem: MarvelItem, modifier: Modifier = Modifier) {
    Column {
        AsyncImage(
            model = marvelItem.thumbnail,
            contentDescription = marvelItem.description,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .fillMaxSize()
                .aspectRatio(1f)
                .background(Color.LightGray)
        )
        Spacer(modifier = modifier.height(8.dp))
        Text(
            text = marvelItem.name,
            style = MaterialTheme.typography.h5,
            maxLines = 2,
            modifier = modifier
                .padding(16.dp, 0.dp)
                .align(Alignment.CenterHorizontally)
        )
        if (marvelItem.description.isNotEmpty()) {
            Spacer(modifier = modifier.height(16.dp))
            Text(
                text = marvelItem.description,
                style = MaterialTheme.typography.body1,
                modifier = modifier.padding(16.dp, 0.dp)
            )
        }
        Spacer(modifier = modifier.height(16.dp))
    }
}
