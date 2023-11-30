package com.clp3z.marvelcompose.ui.screens.events

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.clp3z.marvelcompose.repositories.EventsRepository
import com.clp3z.marvelcompose.repositories.models.Event
import com.clp3z.marvelcompose.ui.screens.common.MarvelListScreen

@Composable
fun EventsScreen(onClick: (Event) -> Unit) {
    var events by rememberSaveable { mutableStateOf(emptyList<Event>()) }

    LaunchedEffect(Unit) {
        events = EventsRepository.getEvents()
    }

    MarvelListScreen(
        items = events,
        onClick = onClick
    )
}
