package com.clp3z.marvelcompose.repository.models

import com.clp3z.marvelcompose.network.models.ThumbnailResponse

data class Thumbnail(
    val path: String,
    val extension: String
)

fun ThumbnailResponse.toThumbnail() = Thumbnail(
    path = path,
    extension = extension
)

fun Thumbnail.asString() = "${path}.${extension}".replace("http", "https")