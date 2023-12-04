package com.clp3z.marvelcompose.ui.screens.common

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.clp3z.marvelcompose.R
import com.clp3z.marvelcompose.repositories.models.MarvelItem
import com.clp3z.marvelcompose.ui.MarvelScreen
import com.clp3z.marvelcompose.ui.models.characters

@Composable
fun <T : MarvelItem> MarvelListScreen(
    items: List<T>,
    onClick: (T) -> Unit
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
        MarvelList(
            items = items,
            onClick = onClick,
            modifier = Modifier.padding(it)
        )
    }
}

@Preview(widthDp = 400, heightDp = 800)
@Composable
private fun MarvelListScreenPreview() {
    MarvelScreen {
        MarvelListScreen(
            items = characters,
            onClick = {}
        )
    }
}
