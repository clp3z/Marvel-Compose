package com.clp3z.marvelcompose.ui.screens.common

import android.content.Context
import androidx.core.app.ShareCompat
import com.clp3z.marvelcompose.repositories.models.MarvelItem

fun shareMarvelItem(context: Context, marvelItem: MarvelItem) {
    ShareCompat.IntentBuilder(context)
        .setType("text/plain")
        .setSubject(marvelItem.name)
        .setText(marvelItem.urls.first().url)
        .intent
        .also { context.startActivity(it) }
}