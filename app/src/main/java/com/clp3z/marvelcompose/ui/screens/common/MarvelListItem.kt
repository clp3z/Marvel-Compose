package com.clp3z.marvelcompose.ui.screens.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.clp3z.marvelcompose.R
import com.clp3z.marvelcompose.repository.models.MarvelItem
import com.clp3z.marvelcompose.ui.MarvelScreen
import com.clp3z.marvelcompose.ui.models.characterPreview
import com.clp3z.marvelcompose.ui.views.AppBarAction

@Composable
fun <T : MarvelItem> MarvelListItem(
    marvelItem: T,
    onItemMoreClicked: (T) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(8.dp)
    ) {
        Card {
            AsyncImage(
                model = marvelItem.thumbnail,
                contentScale = ContentScale.Crop,
                contentDescription = marvelItem.description,
                modifier = modifier
                    .aspectRatio(1f)
                    .background(Color.LightGray)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = marvelItem.name,
                style = MaterialTheme.typography.h6,
                maxLines = 2,
                modifier = modifier
                    .padding(8.dp, 0.dp)
                    .weight(1f)
            )
            AppBarAction(
                imageVector = Icons.Default.MoreVert,
                onClick = { onItemMoreClicked(marvelItem) },
                contentDescription = stringResource(id = R.string.more_options)
            )
        }
    }
}

@Preview
@Composable
fun MarvelListItemPreview() {
    MarvelScreen {
        MarvelListItem(
            marvelItem = characterPreview,
            onItemMoreClicked = {}
        )
    }
}
