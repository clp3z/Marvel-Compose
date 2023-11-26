package com.clp3z.marvelcompose.network.models

data class ThumbnailResponse(
    val extension: String,
    val path: String
)

fun ThumbnailResponse.asString() = "${path}.${extension}".replace("http", "https")