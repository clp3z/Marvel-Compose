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
    @SerializedName("comics") val comicsResponse: ReferenceListResponse,
    @SerializedName("stories") val storiesResponse: ReferenceListResponse,
    @SerializedName("events") val eventsResponse: ReferenceListResponse,
    @SerializedName("series") val seriesResponse: ReferenceListResponse
)

fun CharacterResponse.toCharacter() = Character(
    id = id,
    name = name,
    description = description,
    thumbnail = thumbnailResponse.asString(),
    comics = comicsResponse.items.map { Reference(it.name, it.resourceURI) },
    events = eventsResponse.items.map { Reference(it.name, it.resourceURI) },
    stories = storiesResponse.items.map { Reference(it.name, it.resourceURI) },
    series = seriesResponse.items.map { Reference(it.name, it.resourceURI) },
    urls = urlResponses.map { Url(it.type, it.url) }
)