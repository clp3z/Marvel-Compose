package com.clp3z.marvelcompose.ui.views

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.clp3z.marvelcompose.ui.MarvelScreen
import com.clp3z.marvelcompose.ui.navigation.NavigationItem

@Composable
fun DrawerContent(
    selectedIndex: Int,
    drawerItems: List<NavigationItem>,
    onDrawerItemClicked: (NavigationItem) -> Unit
) {
    Box(
        modifier = Modifier
            .background(
                Brush
                    .verticalGradient(
                        colors = listOf(
                            MaterialTheme.colors.primary,
                            MaterialTheme.colors.secondary
                        )
                    )
            )
            .height(200.dp)
            .fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(16.dp))
    drawerItems.forEachIndexed { index, item ->
        DrawerItem(
            isSelected = index == selectedIndex,
            item = item,
            onDrawerItemClicked = onDrawerItemClicked
        )
    }
}

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DrawerContentPreview() {
    MarvelScreen {
        Column {
            DrawerContent(
                selectedIndex = 0,
                drawerItems = listOf(NavigationItem.HOME, NavigationItem.SETTINGS),
                onDrawerItemClicked = {}
            )
        }
    }
}
