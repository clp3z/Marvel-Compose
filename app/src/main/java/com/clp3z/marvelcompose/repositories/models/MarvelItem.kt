package com.clp3z.marvelcompose.repositories.models

interface MarvelItem {
    val id: Int
    val name: String
    val description: String
    val thumbnail: String
    val references: List<ReferenceList>
    val urls: List<Url>
}
