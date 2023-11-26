package com.clp3z.marvelcompose.network.models

import com.clp3z.marvelcompose.ui.models.Character
import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    val id: Int,
    val name: String,
    val description: String,
    val modified: String,
    val resourceURI: String,
    val urlResponses: List<UrlResponse>,
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
    thumbnail = thumbnailResponse.asString()
)