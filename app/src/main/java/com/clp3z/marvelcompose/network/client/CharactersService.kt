package com.clp3z.marvelcompose.network.client

import com.clp3z.marvelcompose.network.models.CharacterResponse
import com.clp3z.marvelcompose.network.models.ServerResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CharactersService {

    @GET("/v1/public/characters")
    suspend fun getCharacters(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): ServerResponse<CharacterResponse>
}