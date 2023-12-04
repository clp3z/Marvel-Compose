package com.clp3z.marvelcompose.repositories.models

import com.clp3z.marvelcompose.R
import com.clp3z.marvelcompose.network.models.ComicResponse
import com.clp3z.marvelcompose.repositories.models.Comic.Format

data class Comic(
    override val id: Int,
    override val name: String,
    override val description: String,
    override val thumbnail: String,
    override val urls: List<Url>,
    override val references: List<ReferenceList>,
    val format: Format
) : MarvelItem {

    enum class Format {
        COMIC,
        MAGAZINE,
        TRADE_PAPERBACK,
        HARDCOVER,
        DIGEST,
        GRAPHIC_NOVEL,
        DIGITAL_COMIC,
        INFINITE_COMIC
    }
}

fun ComicResponse.toComic() = Comic(
    id = id,
    name = title,
    description = description ?: "",
    thumbnail = thumbnail.toThumbnail().asString(),
    urls = urls.map { it.toUrl() },
    references = listOf(
        characters.toReferenceList(ReferenceList.Type.CHARACTER),
        events.toReferenceList(ReferenceList.Type.EVENT),
        stories.toReferenceList(ReferenceList.Type.STORY)
    ),
    format = format.toFormat()
)

fun String.toFormat() = when (this) {
    "comic" -> Format.COMIC
    "magazine" -> Format.MAGAZINE
    "trade paperback" -> Format.TRADE_PAPERBACK
    "hardcover" -> Format.HARDCOVER
    "digest" -> Format.DIGEST
    "graphic novel" -> Format.GRAPHIC_NOVEL
    "digital comic" -> Format.DIGITAL_COMIC
    "infinite comic" -> Format.INFINITE_COMIC
    else -> Format.COMIC
}

fun Format.asString() = when (this) {
    Format.COMIC -> "comic"
    Format.MAGAZINE -> "magazine"
    Format.TRADE_PAPERBACK -> "trade paperback"
    Format.HARDCOVER -> "hardcover"
    Format.DIGEST -> "digest"
    Format.GRAPHIC_NOVEL -> "graphic novel"
    Format.DIGITAL_COMIC -> "digital comic"
    Format.INFINITE_COMIC -> "infinite comic"
}

fun Format.toStringResourceId() = when (this) {
    Format.COMIC -> R.string.comic
    Format.MAGAZINE -> R.string.magazine
    Format.TRADE_PAPERBACK -> R.string.trade_paperback
    Format.HARDCOVER -> R.string.hardcover
    Format.DIGEST -> R.string.digest
    Format.GRAPHIC_NOVEL -> R.string.graphic_novel
    Format.DIGITAL_COMIC -> R.string.digital_comic
    Format.INFINITE_COMIC -> R.string.infinite_comic
}
