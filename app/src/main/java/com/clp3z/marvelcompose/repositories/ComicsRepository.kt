package com.clp3z.marvelcompose.repositories

import com.clp3z.marvelcompose.network.client.MarvelServerClient
import com.clp3z.marvelcompose.repositories.models.Comic
import com.clp3z.marvelcompose.repositories.models.Comic.Format
import com.clp3z.marvelcompose.repositories.models.asString
import com.clp3z.marvelcompose.repositories.models.toComic

object ComicsRepository : Repository<Comic>() {

    private const val PAGINATION_OFFSET = 0
    private const val NUMBER_OF_CHARACTERS = 100

    suspend fun getComics(format: Format): List<Comic> = super.getItems {
        MarvelServerClient.comicsService
            .getComics(
                offset = PAGINATION_OFFSET,
                limit = NUMBER_OF_CHARACTERS,
                format = format.asString()
            )
            .data
            .results
            .map { it.toComic() }
    }

    suspend fun getComic(id: Int): Comic = super.getItem(id) {
        MarvelServerClient.comicsService
            .getComic(id)
            .data
            .results
            .first()
            .toComic()
    }
}