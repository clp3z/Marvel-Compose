package com.clp3z.marvelcompose.repositories.models

import com.clp3z.marvelcompose.network.models.EventResponse

data class Event(
    override val id: Int,
    override val name: String,
    override val description: String,
    override val thumbnail: String,
    override val urls: List<Url>,
    override val references: List<ReferenceList>
) : MarvelItem

fun EventResponse.toEvent() = Event(
    id = id,
    name = title,
    description = description,
    thumbnail = thumbnail.toThumbnail().asString(),
    urls = urls.map { it.toUrl() },
    references = listOf(
        comics.toReferenceList(ReferenceList.Type.COMIC),
        stories.toReferenceList(ReferenceList.Type.STORY),
        series.toReferenceList(ReferenceList.Type.SERIES),
        characters.toReferenceList(ReferenceList.Type.CHARACTER)
    )
)
