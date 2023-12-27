package com.clp3z.marvelcompose.ui.screens.comics

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.clp3z.marvelcompose.repository.models.Comic
import com.clp3z.marvelcompose.repository.models.toStringResourceId
import com.clp3z.marvelcompose.ui.screens.common.ErrorMessage
import com.clp3z.marvelcompose.ui.screens.common.MarvelList
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ComicsScreen(
    onClick: (Comic) -> Unit,
    viewModel: ComicsViewModel = viewModel(),
) {

    val formats = Comic.Format.values().toList()
    val pagerState = rememberPagerState { formats.size }

    Column {
        ComicsScrollableTabs(pagerState, formats)
        HorizontalPager(state = pagerState) { page ->

            val format = formats[page]
            viewModel.requestFormat(format)
            val viewState by viewModel.viewState.collectAsState()
            val pageState by viewState.getValue(format).collectAsState()

            pageState.comics.fold(
                ifLeft = { ErrorMessage(it) },
                ifRight = {
                    MarvelList(
                        isLoading = pageState.isLoading,
                        items = it,
                        onItemClick = onClick,
                        onItemMoreClick = {} // TODO.
                    )
                }
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ComicsScrollableTabs(
    pagerState: PagerState,
    formats: List<Comic.Format>
) {
    val coroutineScope = rememberCoroutineScope()
    ScrollableTabRow(
        selectedTabIndex = pagerState.currentPage,
        edgePadding = 0.dp,
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
                text = { Text(text = stringResource(id = it.toStringResourceId())) },
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(it.ordinal)
                    }
                }
            )
        }
    }
}
