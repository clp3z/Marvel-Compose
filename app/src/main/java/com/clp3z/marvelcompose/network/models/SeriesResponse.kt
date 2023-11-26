package com.clp3z.marvelcompose.network.models

data class SeriesResponse(
    val available: Int,
    val returned: Int,
    val collectionURI: String,
    val comics: List<SerieResponse>
)