package com.clp3z.marvelcompose.ui.screens.common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.clp3z.marvelcompose.R
import com.clp3z.marvelcompose.repositories.models.MarvelItem
import com.clp3z.marvelcompose.ui.models.characterPreview
import com.clp3z.marvelcompose.ui.views.AppBarAction
import com.clp3z.marvelcompose.ui.views.AppBarOverflowMenu
import com.clp3z.marvelcompose.ui.views.BackNavigationAction
import com.clp3z.marvelcompose.ui.views.MenuItemAction

private fun getOverflowMenuItems(marvelItem: MarvelItem, uriHandler: UriHandler) =
    marvelItem.urls.map {
        MenuItemAction(
            name = it.type,
            onMenuItemClicked = { uriHandler.openUri(it.url) }
        )
    }

@Composable
fun MarvelDetailScaffold(
    marvelItem: MarvelItem,
    onUpClick: () -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {
    val context = LocalContext.current
    val uriHandler = LocalUriHandler.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = marvelItem.name) },
                navigationIcon = { BackNavigationAction(onUpClick) },
                actions = { AppBarOverflowMenu(getOverflowMenuItems(marvelItem, uriHandler)) }
            )
        },
        floatingActionButton = {
            if (marvelItem.urls.isNotEmpty()) {
                FloatingActionButton(onClick = { shareMarvelItem(context, marvelItem) }) {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = stringResource(R.string.share)
                    )
                }
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        bottomBar = {
            BottomAppBar(
                cutoutShape = CircleShape
            ) {
                AppBarAction(imageVector = Icons.Default.Menu, onClick = {})
                Spacer(modifier = Modifier.weight(1f))
                AppBarAction(imageVector = Icons.Default.Favorite, onClick = {})
            }
        },
        content = content
    )
}

@Preview(widthDp = 400, heightDp = 800)
@Composable
private fun CharacterScaffoldPreview() {
    MarvelDetailScaffold(
        marvelItem = characterPreview,
        onUpClick = {},
        content = {}
    )
}
