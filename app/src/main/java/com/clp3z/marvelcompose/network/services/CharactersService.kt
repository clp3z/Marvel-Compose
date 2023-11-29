package com.clp3z.marvelcompose.network.services

import com.clp3z.marvelcompose.network.models.CharacterResponse
import com.clp3z.marvelcompose.network.models.ServerResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharactersService {

    @GET("/v1/public/characters")
    suspend fun getCharacters(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): ServerResponse<CharacterResponse>

    @GET("/v1/public/characters/{id}")
    suspend fun getCharacter(
        @Path("id") id: Int
    ): ServerResponse<CharacterResponse>
}