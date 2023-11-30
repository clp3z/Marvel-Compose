package com.clp3z.marvelcompose.repositories.models

interface MarvelItem {
    val id: Int
    val name: String
    val description: String
    val thumbnail: String
    val references: List<ReferenceList>
    val urls: List<Url>
}

fun MarvelItem.getReferenceList(type: ReferenceList.Type): List<Reference> =
    references
        .filter { it.type == type }
        .map { it.references }
        .flatten()
