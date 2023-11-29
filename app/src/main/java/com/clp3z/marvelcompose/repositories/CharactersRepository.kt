package com.clp3z.marvelcompose.repositories

import com.clp3z.marvelcompose.network.client.MarvelServerClient
import com.clp3z.marvelcompose.network.models.toCharacter
import com.clp3z.marvelcompose.repositories.models.Character

object CharactersRepository {

   private const val PAGINATION_OFFSET = 0
   private const val NUMBER_OF_CHARACTERS = 100

    suspend fun getCharacters(): List<Character> {
        val result = MarvelServerClient.charactersService.getCharacters(
            offset = PAGINATION_OFFSET,
            limit = NUMBER_OF_CHARACTERS
        )

        return result.dataResponse.results.map { it.toCharacter() }
    }

    suspend fun getCharacter(id: Int): Character {
        val result = MarvelServerClient.charactersService.getCharacter(id)
        return result.dataResponse.results.first().toCharacter()
    }
}