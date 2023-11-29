package com.clp3z.marvelcompose.network.models

data class ReferenceListResponse(
    val available: Int,
    val returned: Int,
    val collectionURI: String,
    val items: List<ReferenceResponse>
)
