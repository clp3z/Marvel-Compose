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
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
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
    val localContentColor = if (isSelected) MaterialTheme.colors.primary else MaterialTheme.colors.onSurface

    CompositionLocalProvider(
        LocalTextStyle provides MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold),
        LocalContentColor provides localContentColor
    ) {
        Box {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp, 4.dp)
                    .clickable { onDrawerItemClicked(item) }
                    .clip(RoundedCornerShape(4.dp))
                    .background(
                        when (isSelected) {
                            true -> LocalContentColor.current.copy(alpha = 0.12f)
                            else -> materialColors.surface
                        }
                    )
                    .padding(12.dp)

            ) {
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = "$title icon"
                    )
                }
                Spacer(Modifier.width(16.dp))
                Text(text = title)
            }
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
