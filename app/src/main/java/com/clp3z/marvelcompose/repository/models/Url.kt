package com.clp3z.marvelcompose.repository.models

import com.clp3z.marvelcompose.network.models.UrlResponse

data class Url(
    val type: String,
    val url: String
)

fun UrlResponse.toUrl() = Url(
    type = type,
    url = url
)
