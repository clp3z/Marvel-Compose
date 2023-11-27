package com.clp3z.marvelcompose.ui.screens.detail.views

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.res.stringResource
import com.clp3z.marvelcompose.R
import com.clp3z.marvelcompose.ui.models.Character
import com.clp3z.marvelcompose.ui.views.AppBarOverflowMenu
import com.clp3z.marvelcompose.ui.views.BackNavigationAction
import com.clp3z.marvelcompose.ui.views.MenuItemAction

@Composable
fun CharacterScaffold(
    character: Character,
    onUpClick: () -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {
    val context = LocalContext.current
    val uriHandler = LocalUriHandler.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = character.name) },
                navigationIcon = { BackNavigationAction(onUpClick) },
                actions = { AppBarOverflowMenu(getOverflowMenuItems(character, uriHandler)) }
            )
        },
        floatingActionButton = {
            if (character.urls.isNotEmpty()) {
                FloatingActionButton(onClick = { shareCharacter(context, character) }) {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = stringResource(R.string.share)
                    )
                }
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        content = content
    )
}

private fun getOverflowMenuItems(character: Character, uriHandler: UriHandler) =
    character.urls.map {
        MenuItemAction(
            name = it.type,
            onMenuItemClicked = { uriHandler.openUri(it.url) }
        )
    }
