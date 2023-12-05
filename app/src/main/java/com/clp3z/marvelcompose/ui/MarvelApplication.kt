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
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.clp3z.marvelcompose.R
import com.clp3z.marvelcompose.ui.navigation.Navigation
import com.clp3z.marvelcompose.ui.navigation.NavigationItem
import com.clp3z.marvelcompose.ui.navigation.navigateAndPopToStartDestination
import com.clp3z.marvelcompose.ui.theme.MarvelComposeTheme
import com.clp3z.marvelcompose.ui.views.AppBarAction
import com.clp3z.marvelcompose.ui.views.BackNavigationAction
import com.clp3z.marvelcompose.ui.views.BottomNavigation
import com.clp3z.marvelcompose.ui.views.DrawerContent
import kotlinx.coroutines.launch

@Composable
fun MarvelApplication() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: ""
    val showUpNavigation = currentRoute !in NavigationItem.values().map { it.command.route }
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val drawerItems = listOf(NavigationItem.HOME, NavigationItem.SETTINGS)
    val bottomBarItems = listOf(NavigationItem.CHARACTERS, NavigationItem.COMICS, NavigationItem.EVENTS)
    val showBottomNavigation = currentRoute in bottomBarItems.map { it.command.route }

    val drawerSelectedIndex = if (showBottomNavigation)
        drawerItems.indexOf(NavigationItem.HOME)
    else
        drawerItems.indexOfFirst { it.command.route == currentRoute }

    MarvelScreen {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = stringResource(id = R.string.app_name)) },
                    navigationIcon = {
                        when (showUpNavigation){
                            true -> BackNavigationAction(navController::navigateUp)
                            false -> AppBarAction(
                                imageVector = Icons.Default.Menu,
                                onClick = {
                                    coroutineScope.launch { scaffoldState.drawerState.open() }
                                }
                            )
                        }
                    } 
                )
            },
            bottomBar = {
                if (showBottomNavigation) {
                    BottomNavigation(
                        navigationItems = bottomBarItems,
                        currentRoute = currentRoute,
                        onNavigationItemClicked = {
                            navController.navigateAndPopToStartDestination(it)
                        }
                    )
                }
            },
            drawerContent = {
                DrawerContent(
                    selectedIndex = drawerSelectedIndex,
                    drawerItems = drawerItems,
                    onDrawerItemClicked = {
                        coroutineScope.launch { scaffoldState.drawerState.close() }
                        navController.navigate(it.command.route)
                    }
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

@Composable
fun MarvelScreen(content: @Composable () -> Unit) {
    MarvelComposeTheme {
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}
