package com.clp3z.marvelcompose.ui

import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.clp3z.marvelcompose.ui.navigation.NavigationItem
import com.clp3z.marvelcompose.ui.navigation.navigateAndPopToStartDestination
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun rememberMarvelApplicationState(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope()
) = remember(scaffoldState, navController, coroutineScope) {
    MarvelApplicationState(scaffoldState,navController,coroutineScope)
}

class MarvelApplicationState(
    val scaffoldState: ScaffoldState,
    val navController: NavHostController,
    private val coroutineScope: CoroutineScope
) {

    companion object {
        val DRAWER_ITEMS = listOf(
            NavigationItem.HOME,
            NavigationItem.SETTINGS
        )

        val BOTTOM_BAR_ITEMS = listOf(
            NavigationItem.CHARACTERS,
            NavigationItem.COMICS,
            NavigationItem.EVENTS
        )
    }

    val currentRoute: String
        @Composable get() = navController
            .currentBackStackEntryAsState()
            .value?.destination?.route
            ?: ""

    val showUpNavigation: Boolean
        @Composable get() = currentRoute !in NavigationItem.values().map { it.command.route }

    val showBottomNavigation: Boolean
        @Composable get() = currentRoute in BOTTOM_BAR_ITEMS.map { it.command.route }

    val drawerSelectedIndex: Int
        @Composable get() = when (showBottomNavigation) {
            true -> DRAWER_ITEMS.indexOf(NavigationItem.HOME)
            else -> DRAWER_ITEMS.indexOfFirst { it.command.route == currentRoute }
        }

    fun onUpClicked() = navController.navigateUp()

    fun onMenuClicked() = coroutineScope.launch { scaffoldState.drawerState.open() }

    fun onNavigationItemClicked(navigationItem: NavigationItem) =
        navController.navigateAndPopToStartDestination(navigationItem)

    fun onDrawerItemClicked(navigationItem: NavigationItem) {
        coroutineScope.launch { scaffoldState.drawerState.close() }
        onNavigationItemClicked(navigationItem)
    }
}