package com.clp3z.marvelcompose.ui.models

import com.clp3z.marvelcompose.repositories.models.Character
import com.clp3z.marvelcompose.repositories.models.Reference
import com.clp3z.marvelcompose.repositories.models.Url

val characterPreview = Character(
    id = 1011334,
    name = "3-D Man",
    description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
    thumbnail = "https://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784.jpg",
    comics = listOf(Reference(name = "Comic 1", url = ""), Reference(name = "Comic 2", url = "")),
    events = listOf(Reference(name = "Event 1", url = ""), Reference(name = "Event 2", url = "")),
    stories = listOf(Reference(name = "Story 1", url = ""), Reference(name = "Story 2", url = "")),
    series = listOf(Reference(name = "Series 1", url = ""), Reference(name = "Series 2", url = "")),
    urls = listOf(Url(type = "detail", url = ""), Url(type = "other", url = ""))
)

val characters = listOf(characterPreview, characterPreview, characterPreview, characterPreview)