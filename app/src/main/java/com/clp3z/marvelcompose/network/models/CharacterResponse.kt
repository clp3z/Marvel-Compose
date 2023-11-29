package com.clp3z.marvelcompose.network.models

data class CharacterResponse(
    val id: Int,
    val name: String,
    val description: String,
    val modified: String,
    val resourceURI: String,
    val urls: List<UrlResponse>,
    val thumbnail: ThumbnailResponse,
    val comics: ReferenceListResponse,
    val stories: ReferenceListResponse,
    val events: ReferenceListResponse,
    val series: ReferenceListResponse
)
