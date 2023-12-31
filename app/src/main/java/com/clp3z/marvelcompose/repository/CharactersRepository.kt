package com.clp3z.marvelcompose.repository

import com.clp3z.marvelcompose.network.client.MarvelServerClient
import com.clp3z.marvelcompose.repository.models.Character
import com.clp3z.marvelcompose.repository.models.Result
import com.clp3z.marvelcompose.repository.models.toCharacter

object CharactersRepository: Repository<Character>() {

    private const val PAGINATION_OFFSET = 0
    private const val NUMBER_OF_CHARACTERS = 100

    suspend fun getCharacters(): Result<List<Character>> = super.getItems {
        MarvelServerClient.charactersService
            .getCharacters(
                offset = PAGINATION_OFFSET,
                limit = NUMBER_OF_CHARACTERS
            )
            .data
            .results
            .map { it.toCharacter() }
    }

    suspend fun getCharacter(id: Int): Result<Character> = super.getItem(id) {
        MarvelServerClient.charactersService
            .getCharacter(id)
            .data
            .results
            .first()
            .toCharacter()
    }
}
