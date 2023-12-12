package com.clp3z.marvelcompose.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.clp3z.marvelcompose.R
import com.clp3z.marvelcompose.ui.navigation.Navigation
import com.clp3z.marvelcompose.ui.theme.MarvelComposeTheme
import com.clp3z.marvelcompose.ui.views.AppBarAction
import com.clp3z.marvelcompose.ui.views.BackNavigationAction
import com.clp3z.marvelcompose.ui.views.BottomNavigation
import com.clp3z.marvelcompose.ui.views.DrawerContent

@Composable
fun MarvelApplication() {
    val applicationState = rememberMarvelApplicationState()

    with(applicationState) {
        MarvelScreen {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text(text = stringResource(id = R.string.app_name)) },
                        navigationIcon = {
                            when (showUpNavigation){
                                true -> BackNavigationAction(
                                    onUpClick = { applicationState.onUpClicked() }
                                )
                                false -> AppBarAction(
                                    imageVector = Icons.Default.Menu,
                                    onClick = { applicationState.onMenuClicked() }
                                )
                            }
                        }
                    )
                },
                bottomBar = {
                    if (showBottomNavigation) {
                        BottomNavigation(
                            navigationItems = MarvelApplicationState.BOTTOM_BAR_ITEMS,
                            currentRoute = currentRoute,
                            onNavigationItemClicked = { applicationState.onNavigationItemClicked(it)}
                        )
                    }
                },
                drawerContent = {
                    DrawerContent(
                        selectedIndex = drawerSelectedIndex,
                        drawerItems = MarvelApplicationState.DRAWER_ITEMS,
                        onDrawerItemClicked = { applicationState.onDrawerItemClicked(it) }
                    )
                },
                scaffoldState = scaffoldState
            ) {
                Box(modifier = Modifier.padding(it)) {
                    Navigation(navController)
                }
            }
        }
    }
}

@Composable
fun MarvelScreen(content: @Composable () -> Unit) {
    MarvelComposeTheme {
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}
