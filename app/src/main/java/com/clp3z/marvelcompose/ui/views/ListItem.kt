package com.clp3z.marvelcompose.ui.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Event
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ListItem(name: String, icon: ImageVector, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Row {
            Icon(imageVector = icon, contentDescription = "$name icon")
            Spacer(Modifier.width(8.dp))
            Text(
                text = name,
                style = MaterialTheme.typography.body1
            )
        }
    }
}

@Preview(widthDp = 400, heightDp = 400)
@Composable
fun CustomListItemPreview() {
    ListItem(name = "Event", icon = Icons.Filled.Event)
}
