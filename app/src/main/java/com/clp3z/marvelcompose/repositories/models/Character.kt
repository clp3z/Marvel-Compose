package com.clp3z.marvelcompose.repositories.models

import com.clp3z.marvelcompose.network.models.CharacterResponse

data class Character(
    override val id: Int,
    override val name: String,
    override val description: String,
    override val thumbnail: String,
    override val urls: List<Url>,
    override val references: List<ReferenceList>
) : MarvelItem

fun CharacterResponse.toCharacter() = Character(
    id = id,
    name = name,
    description = description,
    thumbnail = thumbnail.toThumbnail().asString(),
    urls = urls.map { Url(it.type, it.url) },
    references = listOf(
        comics.toReferenceList(ReferenceList.Type.COMIC),
        stories.toReferenceList(ReferenceList.Type.STORY),
        events.toReferenceList(ReferenceList.Type.EVENT),
        series.toReferenceList(ReferenceList.Type.SERIES)
    )
)
