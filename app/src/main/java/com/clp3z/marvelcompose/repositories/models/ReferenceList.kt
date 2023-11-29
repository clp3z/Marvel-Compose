package com.clp3z.marvelcompose.repositories.models

import com.clp3z.marvelcompose.network.models.ReferenceListResponse

data class ReferenceList(
    val type: Type,
    val references: List<Reference>
) {

    enum class Type {
        CHARACTER,
        COMIC,
        STORY,
        EVENT,
        SERIES
    }
}

fun ReferenceListResponse.toReferenceList(type: ReferenceList.Type) = ReferenceList(
    type,
    items
        ?.let { items.map { it.toReference() } }
        ?: emptyList()
)
