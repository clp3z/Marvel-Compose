package com.clp3z.marvelcompose.network.models

data class EventResponse(
    val id: Int,
    val title: String,
    val description: String,
    val resourceURI: String,
    val urls: List<UrlResponse>,
    val modified: String,
    val start: String,
    val end: String,
    val thumbnail: ThumbnailResponse,
    val comics: ReferenceListResponse,
    val stories: ReferenceListResponse,
    val series: ReferenceListResponse,
    val characters: ReferenceListResponse,
    val previous: ReferenceResponse,
    val next: ReferenceResponse
)
