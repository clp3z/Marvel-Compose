package com.clp3z.marvelcompose.network.services

import com.clp3z.marvelcompose.network.models.EventResponse
import com.clp3z.marvelcompose.network.models.ServerResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EventsService {

    @GET("/v1/public/events")
    suspend fun getEvents(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): ServerResponse<EventResponse>

    @GET("/v1/public/events/{eventId}")
    suspend fun getEvent(
        @Path("eventId") eventId: Int,
    ): ServerResponse<EventResponse>
}
