package com.clp3z.marvelcompose.ui.models

data class Character(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: String,
    val comics: List<Reference>,
    val events: List<Reference>,
    val stories: List<Reference>,
    val series: List<Reference>
)