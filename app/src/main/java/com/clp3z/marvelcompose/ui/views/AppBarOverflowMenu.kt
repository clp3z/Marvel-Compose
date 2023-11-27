package com.clp3z.marvelcompose.ui.views

import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import com.clp3z.marvelcompose.R

data class MenuItemAction(
    val name: String,
    val onMenuItemClicked: () -> Unit
)

@Composable
fun AppBarOverflowMenu(
    items: List<MenuItemAction>,
    contentDescription: String? = null
) {
    var showDropdownMenu by remember { mutableStateOf(false) }

    IconButton(onClick = { showDropdownMenu = !showDropdownMenu }) {
        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = contentDescription ?: stringResource(R.string.more_options)
        )
        DropdownMenu(
            expanded = showDropdownMenu,
            onDismissRequest = { showDropdownMenu = false }
        ) {
            items.forEach {
                DropdownMenuItem(
                    onClick = {
                        showDropdownMenu = false
                        it.onMenuItemClicked()
                    }
                ) {
                    Text(text = it.name)
                }
            }
        }
    }
}
