package com.clp3z.marvelcompose.ui.screens.detail.views

import android.content.Context
import androidx.core.app.ShareCompat
import com.clp3z.marvelcompose.ui.models.Character

fun shareCharacter(context: Context, character: Character) {
    ShareCompat.IntentBuilder(context)
        .setType("text/plain")
        .setSubject(character.name)
        .setText(character.urls.first().url)
        .intent
        .also { context.startActivity(it) }
}