package com.clp3z.marvelcompose.ui.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.clp3z.marvelcompose.ui.navigation.NavigationItem

@Composable
fun DrawerItem(item: NavigationItem, onDrawerItemClicked: (NavigationItem) -> Unit) {
    val title = stringResource(id = item.title)
    Box {
        Row(
            modifier = Modifier
                .clickable { onDrawerItemClicked(item) }
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Icon(
                imageVector = item.icon,
                contentDescription = "$title icon"
            )
            Spacer(Modifier.width(16.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.body1
            )
        }
    }
}

@Preview
@Composable
fun DrawerItemPreview() {
    DrawerItem(
        item = NavigationItem.HOME,
        onDrawerItemClicked = {}
    )
}
