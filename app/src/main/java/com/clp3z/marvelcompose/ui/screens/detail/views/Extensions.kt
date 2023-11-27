package com.clp3z.marvelcompose.ui.screens.detail.views

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.clp3z.marvelcompose.ui.models.Reference
import com.clp3z.marvelcompose.ui.views.ListItem

fun LazyListScope.section(
    name: String,
    icon: ImageVector,
    items: List<Reference>
) {
    if (items.isEmpty()) return
    item {
        Text(
            text = name,
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
