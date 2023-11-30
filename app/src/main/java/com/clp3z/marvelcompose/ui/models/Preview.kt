package com.clp3z.marvelcompose.ui.models

import com.clp3z.marvelcompose.repositories.models.Character
import com.clp3z.marvelcompose.repositories.models.Comic
import com.clp3z.marvelcompose.repositories.models.Event
import com.clp3z.marvelcompose.repositories.models.Reference
import com.clp3z.marvelcompose.repositories.models.ReferenceList
import com.clp3z.marvelcompose.repositories.models.Url

val characterPreview = Character(
    id = 1011334,
    name = "3-D Man",
    description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
    thumbnail = "https://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784.jpg",
    urls = listOf(Url(type = "detail", url = ""), Url(type = "other", url = "")),
    references = listOf(
        ReferenceList(
            type = ReferenceList.Type.CHARACTER,
            references = listOf(Reference(name = "Character 1", url = ""), Reference(name = "Character 2", url = ""))
        ),
        ReferenceList(
            type = ReferenceList.Type.COMIC,
            references = listOf(Reference(name = "Comic 1", url = ""), Reference(name = "Comic 2", url = ""))
        ),
        ReferenceList(
            type = ReferenceList.Type.STORY,
            references = listOf(Reference(name = "Story 1", url = ""), Reference(name = "Story 2", url = ""))
        )
    )
)

val comicPreview = Comic(
    id = 1,
    name = "Amazing Spider-Man #1",
    description = "Spider-Man's greatest adventure begins!",
    thumbnail = "https://example.com/comic-thumbnail.jpg",
    urls = listOf(
        Url(type = "detail", url = "https://example.com/comic/1"),
        Url(type = "wiki", url = "https://en.wikipedia.org/wiki/Amazing_Spider-Man_(1963)")
    ),
    references = listOf(
        ReferenceList(
            type = ReferenceList.Type.CHARACTER,
            references = listOf(Reference(name = "Character 1", url = ""), Reference(name = "Character 2", url = ""))
        ),
        ReferenceList(
            type = ReferenceList.Type.COMIC,
            references = listOf(Reference(name = "Comic 1", url = ""), Reference(name = "Comic 2", url = ""))
        ),
        ReferenceList(
            type = ReferenceList.Type.STORY,
            references = listOf(Reference(name = "Story 1", url = ""), Reference(name = "Story 2", url = ""))
        )
    ),
    format = Comic.Format.COMIC
)

val eventPreview = Event(
    id = 1,
    name = "Secret Wars",
    description = "A cosmic event that will change the Marvel Universe forever!",
    thumbnail = "https://example.com/event-thumbnail.jpg",
    urls = listOf(
        Url(type = "detail", url = "https://example.com/event/1"),
        Url(type = "wiki", url = "https://en.wikipedia.org/wiki/Secret_Wars_(2015)")
    ),
    references = listOf(
        ReferenceList(
            type = ReferenceList.Type.CHARACTER,
            references = listOf(Reference(name = "Character 1", url = ""), Reference(name = "Character 2", url = ""))
        ),
        ReferenceList(
            type = ReferenceList.Type.COMIC,
            references = listOf(Reference(name = "Comic 1", url = ""), Reference(name = "Comic 2", url = ""))
        ),
        ReferenceList(
            type = ReferenceList.Type.STORY,
            references = listOf(Reference(name = "Story 1", url = ""), Reference(name = "Story 2", url = ""))
        )
    )
)

val characters = listOf(characterPreview, characterPreview, characterPreview, characterPreview)