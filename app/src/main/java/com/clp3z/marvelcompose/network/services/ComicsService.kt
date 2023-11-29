package com.clp3z.marvelcompose.network.services

import com.clp3z.marvelcompose.network.models.ComicResponse
import com.clp3z.marvelcompose.network.models.ServerResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ComicsService {

    @GET("/v1/public/comics")
    suspend fun getComics(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
        @Query("format") format: String?
    ): ServerResponse<ComicResponse>

    @GET("/v1/public/comics/{comicId}")
    suspend fun getComic(
        @Path("id") comicId: Int,
    ): ServerResponse<ComicResponse>
}