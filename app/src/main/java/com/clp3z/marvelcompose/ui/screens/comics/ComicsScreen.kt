package com.clp3z.marvelcompose.ui.screens.comics

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.clp3z.marvelcompose.repositories.ComicsRepository
import com.clp3z.marvelcompose.repositories.models.Comic
import com.clp3z.marvelcompose.ui.screens.common.MarvelList
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ComicsScreen(onClick: (Comic) -> Unit) {
    var comics by rememberSaveable { mutableStateOf(emptyList<Comic>()) }

    LaunchedEffect(Unit) {
        comics = ComicsRepository.getComics()
    }

    val formats = Comic.Format.values().take(3)
    val pagerState = rememberPagerState { formats.size }
    val coroutineScope = rememberCoroutineScope()

    Column {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            indicator = { tabPositions ->
                // This doesn't work on material 1.5.X
                TabRowDefaults.Indicator(
                    Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage])
                )
            }
        ) {
            formats.forEach {
                Tab(
                    selected = it.ordinal == pagerState.currentPage,
                    text = { Text(text = it.name) },
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(it.ordinal)
                        }
                    }
                )
            }
        }
        HorizontalPager(state = pagerState) {
            MarvelList(
                items = comics,
                onClick = onClick
            )
        }
    }
}
