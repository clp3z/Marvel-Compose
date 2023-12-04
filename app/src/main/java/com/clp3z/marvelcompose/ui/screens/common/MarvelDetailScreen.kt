package com.clp3z.marvelcompose.ui.screens.common

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.clp3z.marvelcompose.repositories.models.MarvelItem
import com.clp3z.marvelcompose.ui.screens.characters.section
import com.clp3z.marvelcompose.ui.screens.characters.toSectionPairData

@Composable
fun <T : MarvelItem> MarvelDetailScreen(item: T) {
    MarvelDetailScaffold(marvelItem = item) {
        LazyColumn (
            modifier = Modifier
            .fillMaxWidth()
            .padding(it)
        ) {
            item {
                Header(item)
            }
            item.references.forEach {
                val (icon, @StringRes title) = it.type.toSectionPairData()
                section(
                    titleId = title,
                    icon = icon,
                    items = it.references
                )
            }
        }
    }
}
