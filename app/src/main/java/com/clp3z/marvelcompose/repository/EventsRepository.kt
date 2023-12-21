package com.clp3z.marvelcompose.repository

import com.clp3z.marvelcompose.network.client.MarvelServerClient
import com.clp3z.marvelcompose.repository.models.Event
import com.clp3z.marvelcompose.repository.models.Result
import com.clp3z.marvelcompose.repository.models.toEvent

object EventsRepository : Repository<Event>() {

    private const val PAGINATION_OFFSET = 0
    private const val NUMBER_OF_CHARACTERS = 100

    suspend fun getEvents(): Result<List<Event>> = super.getItems {
        MarvelServerClient.eventsService
            .getEvents(
                offset = PAGINATION_OFFSET,
                limit = NUMBER_OF_CHARACTERS
            )
            .data
            .results
            .map { it.toEvent() }
    }

    suspend fun getEvent(id: Int): Result<Event> = super.getItem(id) {
        MarvelServerClient.eventsService
            .getEvent(id)
            .data
            .results
            .first()
            .toEvent()
    }
}
