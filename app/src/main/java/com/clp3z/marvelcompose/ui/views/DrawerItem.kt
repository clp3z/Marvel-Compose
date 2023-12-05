package com.clp3z.marvelcompose.ui.views

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.clp3z.marvelcompose.ui.MarvelScreen
import com.clp3z.marvelcompose.ui.navigation.NavigationItem

@Composable
fun DrawerItem(
    isSelected: Boolean = false,
    item: NavigationItem,
    onDrawerItemClicked: (NavigationItem) -> Unit
) {
    val title = stringResource(id = item.title)
    val materialColors = MaterialTheme.colors
    Box {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp, 4.dp)
                .clickable { onDrawerItemClicked(item) }
                .clip(RoundedCornerShape(4.dp))
                .background(
                    when {
                        isSelected -> materialColors.primary.copy(alpha = 0.12f)
                        else -> materialColors.surface
                    }
                )
                .padding(12.dp)

        ) {
            Icon(
                imageVector = item.icon,
                contentDescription = "$title icon",
                tint = when (isSelected) {
                    true -> materialColors.primary
                    else -> materialColors.onSurface.copy(
                        alpha = ContentAlpha.medium
                    )
                }
            )
            Spacer(Modifier.width(16.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.body1,
                color = when (isSelected) {
                    true -> materialColors.primary
                    else -> materialColors.onSurface
                }
            )
        }
    }
}

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DrawerItemPreview() {
    MarvelScreen {
        DrawerItem(
            isSelected = true,
            item = NavigationItem.HOME,
            onDrawerItemClicked = {}
        )
    }
}
