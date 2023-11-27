package com.clp3z.marvelcompose.network.models

import com.google.gson.annotations.SerializedName

data class SeriesResponse(
    val available: Int,
    val returned: Int,
    val collectionURI: String,
    @SerializedName("items") val series: List<SerieResponse>
)