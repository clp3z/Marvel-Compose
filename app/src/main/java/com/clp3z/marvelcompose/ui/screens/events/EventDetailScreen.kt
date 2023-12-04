package com.clp3z.marvelcompose.ui.screens.events

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.clp3z.marvelcompose.repositories.EventsRepository
import com.clp3z.marvelcompose.repositories.models.Event
import com.clp3z.marvelcompose.ui.models.eventPreview
import com.clp3z.marvelcompose.ui.screens.common.MarvelDetailScreen

@Composable
fun EventDetailScreen(id: Int) {
    var event by remember { mutableStateOf<Event?>(null) }

    LaunchedEffect(Unit) {
        event = EventsRepository.getEvent(id)
    }

    event?.let {
        MarvelDetailScreen(it)
    }
}

@Preview(widthDp = 400, heightDp = 800)
@Composable
fun EventDetailScreenPreview() {
    MarvelDetailScreen(eventPreview)
}
