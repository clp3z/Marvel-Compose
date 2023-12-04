package com.clp3z.marvelcompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable

internal fun NavGraphBuilder.composable(
    navigationCommand: NavigationCommand,
    content: @Composable (NavBackStackEntry) -> Unit
) {
    composable(
        route = navigationCommand.route,
        arguments = navigationCommand.arguments
    ) {
        content(it)
    }
}

internal inline fun <reified T> NavBackStackEntry.findArgument(
    navigationArgument: NavigationArgument,
    message: String = "Argument ${navigationArgument.key} not found"
): T {
    val value = when (navigationArgument.navType) {
        NavType.IntType -> arguments?.getInt(navigationArgument.key)
        else -> throw IllegalArgumentException("Unknown argument type: ${navigationArgument.navType}")
    }
    requireNotNull(value) { message }
    return value as T
}

internal fun NavHostController.navigateAndPopToStartDestination(item: NavigationItem) {
    navigate(item.command.route)  {
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}