package com.clp3z.marvelcompose.ui.screens.common

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Collections
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.clp3z.marvelcompose.common.capitalize
import com.clp3z.marvelcompose.repositories.models.MarvelItem
import com.clp3z.marvelcompose.ui.screens.characters.section

@Composable
fun <T : MarvelItem> MarvelDetailScreen(item: T, onUpClick: () -> Unit) {
    MarvelDetailScaffold(
        marvelItem = item,
        onUpClick = onUpClick
    ) {
        LazyColumn (modifier = Modifier.padding(it)) {
            item {
                Header(item)
            }
            item.references.forEach { referenceList ->
                section(
                    name = referenceList.type.name.capitalize(),
                    icon = Icons.Default.Collections,
                    items = referenceList.references
                )
            }
        }
    }
}
