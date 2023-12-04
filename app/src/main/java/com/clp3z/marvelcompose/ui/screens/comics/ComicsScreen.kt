package com.clp3z.marvelcompose.ui.screens.comics

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.clp3z.marvelcompose.R
import com.clp3z.marvelcompose.repositories.ComicsRepository
import com.clp3z.marvelcompose.repositories.models.Comic
import com.clp3z.marvelcompose.ui.screens.common.MarvelList

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ComicsScreen(onClick: (Comic) -> Unit) {
    var comics by rememberSaveable { mutableStateOf(emptyList<Comic>()) }

    LaunchedEffect(Unit) {
        comics = ComicsRepository.getComics()
    }

    val formats = Comic.Format.values()
    val pagerState = rememberPagerState { formats.size }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.app_name))
                }
            )
        }
    ) {
        val modifier = Modifier.padding(it)
        HorizontalPager(
            state = pagerState,
            modifier = modifier
        ) {
            MarvelList(
                items = comics,
                onClick = onClick,
                modifier = modifier
            )
        }
    }
}
