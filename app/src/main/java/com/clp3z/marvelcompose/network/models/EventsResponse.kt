package com.clp3z.marvelcompose.network.models

import com.google.gson.annotations.SerializedName

data class EventsResponse(
    val available: Int,
    val returned: Int,
    val collectionURI: String,
    @SerializedName("items") val events: List<EventReponse>
)