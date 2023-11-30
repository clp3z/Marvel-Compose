package com.clp3z.marvelcompose.repositories

import com.clp3z.marvelcompose.network.client.MarvelServerClient
import com.clp3z.marvelcompose.repositories.models.Event
import com.clp3z.marvelcompose.repositories.models.toEvent

object EventsRepository : Repository<Event>() {

    private const val PAGINATION_OFFSET = 0
    private const val NUMBER_OF_CHARACTERS = 100

    suspend fun getEvents(): List<Event> = super.getItems {
        MarvelServerClient.eventsService
            .getEvents(
                offset = PAGINATION_OFFSET,
                limit = NUMBER_OF_CHARACTERS
            )
            .data
            .results
            .map { it.toEvent() }
    }

    suspend fun getEvent(id: Int): Event = super.getItem(id) {
        MarvelServerClient.eventsService
            .getEvent(id)
            .data
            .results
            .first()
            .toEvent()
    }
}
