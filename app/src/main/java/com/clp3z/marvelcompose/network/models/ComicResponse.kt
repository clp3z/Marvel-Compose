package com.clp3z.marvelcompose.network.models

data class ComicResponse(
    val id: Int,
    val digitalId: Int,
    val title: String,
    val issueNumber: Double,
    val variantDescription: String,
    val description: String,
    val modified: String,
    val isbn: String,
    val upc: String,
    val diamondCode: String,
    val ean: String,
    val issn: String,
    val format: String,
    val pageCount: Int,
    val resourceURI: String,
    val urls: List<UrlResponse>,
    val series: ReferenceResponse,
    val variants: List<ReferenceResponse>,
    val prices: List<PriceResponse>,
    val thumbnail: ThumbnailResponse,
    val creators: ReferenceListResponse,
    val characters: ReferenceListResponse,
    val stories: ReferenceListResponse,
    val events: ReferenceListResponse
)
