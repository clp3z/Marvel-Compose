package com.clp3z.marvelcompose.network.models

import com.clp3z.marvelcompose.ui.models.Character
import com.clp3z.marvelcompose.ui.models.Reference
import com.clp3z.marvelcompose.ui.models.Url
import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    val id: Int,
    val name: String,
    val description: String,
    val modified: String,
    val resourceURI: String,
    @SerializedName("urls") val urlResponses: List<UrlResponse>,
    @SerializedName("thumbnail") val thumbnailResponse: ThumbnailResponse,
    @SerializedName("comics") val comicsResponse: ComicsResponse,
    @SerializedName("stories") val storiesResponse: StoriesResponse,
    @SerializedName("events") val eventsResponse: EventsResponse,
    @SerializedName("series") val seriesResponse: SeriesResponse
)

fun CharacterResponse.toCharacter() = Character(
    id = id,
    name = name,
    description = description,
    thumbnail = thumbnailResponse.asString(),
    comics = comicsResponse.comics.map { Reference(it.name, it.resourceURI) },
    events = eventsResponse.events.map { Reference(it.name, it.resourceURI) },
    stories = storiesResponse.stories.map { Reference(it.name, it.resourceURI) },
    series = seriesResponse.series.map { Reference(it.name, it.resourceURI) },
    urls = urlResponses.map { Url(it.type, it.url) }
)