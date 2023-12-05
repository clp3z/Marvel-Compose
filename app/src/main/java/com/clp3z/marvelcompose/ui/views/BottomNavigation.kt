package com.clp3z.marvelcompose.ui.views

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.clp3z.marvelcompose.ui.navigation.NavigationItem

@Composable
fun BottomNavigation(
    navigationItems: List<NavigationItem>,
    currentRoute: String,
    onNavigationItemClicked: (NavigationItem) -> Unit
) {
    BottomNavigation {
        navigationItems.forEach { item ->
            val title = stringResource(id = item.title)
            BottomNavigationItem(
                label = { Text(text = title) },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = title
                    )
                },
                selected = currentRoute.contains(item.command.feature.route),
                onClick = { onNavigationItemClicked(item) }
            )
        }
    }
}