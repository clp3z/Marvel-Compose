package com.clp3z.marvelcompose.ui.screens.common

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.clp3z.marvelcompose.repositories.models.MarvelItem
import com.clp3z.marvelcompose.ui.screens.characters.section
import com.clp3z.marvelcompose.ui.screens.characters.toSectionPairData

@Composable
fun <T : MarvelItem> MarvelDetailScreen(
    isLoading: Boolean,
    item: T?
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (isLoading) CircularProgressIndicator()

        item?.let { marvelItem ->
            MarvelDetailScaffold(marvelItem = marvelItem) { paddingValues ->
                LazyColumn (
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.TopCenter)
                        .padding(paddingValues)
                ) {
                    item {
                        Header(marvelItem)
                    }
                    marvelItem.references.forEach {
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
    }
}
