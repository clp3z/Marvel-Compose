package com.clp3z.marvelcompose.ui.screens.characters

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Collections
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.clp3z.marvelcompose.R
import com.clp3z.marvelcompose.repositories.models.Reference
import com.clp3z.marvelcompose.repositories.models.ReferenceList
import com.clp3z.marvelcompose.ui.views.ListItem

fun LazyListScope.section(
    @StringRes titleId: Int,
    icon: ImageVector,
    items: List<Reference>
) {
    if (items.isEmpty()) return
    item {
        Text(
            text = stringResource(id = titleId),
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 8.dp)
        )
    }
    items(items) { reference ->
        ListItem(
            name = reference.name,
            icon = icon,
            modifier = Modifier.padding(16.dp, 8.dp)
        )
    }
    item {
        Spacer(modifier = Modifier.height(16.dp))
    }
}

fun ReferenceList.Type.toSectionPairData(): Pair<ImageVector, Int> = when (this) {
    ReferenceList.Type.CHARACTER -> Icons.Default.Person to R.string.characters
    ReferenceList.Type.COMIC -> Icons.Default.Book to R.string.comics
    ReferenceList.Type.STORY -> Icons.Default.Bookmark to R.string.stories
    ReferenceList.Type.EVENT -> Icons.Default.Event to R.string.events
    ReferenceList.Type.SERIES -> Icons.Default.Collections to R.string.series
}
