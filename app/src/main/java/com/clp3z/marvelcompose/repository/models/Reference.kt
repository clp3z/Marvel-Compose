package com.clp3z.marvelcompose.repository.models

import com.clp3z.marvelcompose.network.models.ReferenceResponse

data class Reference(
    val name: String,
    val url: String
)

fun ReferenceResponse.toReference() = Reference(
    name = name,
    url = resourceURI
)
