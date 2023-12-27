package com.clp3z.marvelcompose.ui.screens.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.clp3z.marvelcompose.R
import com.clp3z.marvelcompose.repository.models.MarvelItem
import com.clp3z.marvelcompose.ui.MarvelScreen
import com.clp3z.marvelcompose.ui.models.characterPreview

@Composable
fun <T : MarvelItem> MarvelItemBottomSheet(
    item: T?,
    onGoToDetailsClick: (T) -> Unit
) {
    if (item != null) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(8.dp)
        ) {
            AsyncImage(
                model = item.thumbnail,
                contentDescription = item.name,
                modifier = Modifier
                    .width(96.dp)
                    .aspectRatio(1 / 1.5f)
                    .background(Color.LightGray)
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = item.name,
                    style = MaterialTheme.typography.h6
                )
                Text(
                    text = item.description,
                    textAlign = TextAlign.Justify
                )
                Button(
                    onClick = { onGoToDetailsClick(item) },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text(text = stringResource(id = R.string.go_to_details))
                }
            }
        }
    } else {
        // If the bottom sheet cannot calculate its height because it doesn't have content an error will be produced.
        // This won't be displayed, but is necessary so the component doesn't fail.
        Spacer(modifier = Modifier.height(1.dp))
    }
}

@Preview
@Composable
fun MarvelItemBottomSheetPreview() {
    MarvelScreen {
        MarvelItemBottomSheet(
            item = characterPreview,
            onGoToDetailsClick = {}
        )
    }
}