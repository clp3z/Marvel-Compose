package com.clp3z.marvelcompose.repository

import com.clp3z.marvelcompose.network.client.MarvelServerClient
import com.clp3z.marvelcompose.repository.models.Comic
import com.clp3z.marvelcompose.repository.models.Comic.Format
import com.clp3z.marvelcompose.repository.models.Result
import com.clp3z.marvelcompose.repository.models.asString
import com.clp3z.marvelcompose.repository.models.toComic
import com.clp3z.marvelcompose.repository.models.tryCall

object ComicsRepository {

    private const val PAGINATION_OFFSET = 0
    private const val NUMBER_OF_CHARACTERS = 20

    suspend fun getComics(format: Format = Format.COMIC): Result<List<Comic>> = tryCall {
        MarvelServerClient
            .comicsService
            .getComics(
                offset = PAGINATION_OFFSET,
                limit = NUMBER_OF_CHARACTERS,
                format = format.asString()
            )
            .data
            .results
            .map { it.toComic() }
    }

    suspend fun getComic(id: Int): Result<Comic> = tryCall {
        MarvelServerClient
            .comicsService
            .getComic(id)
            .data
            .results
            .first()
            .toComic()
    }
}
