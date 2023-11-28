package com.clp3z.marvelcompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.clp3z.marvelcompose.ui.screens.characters.CharactersScreen
import com.clp3z.marvelcompose.ui.screens.detail.CharacterDetailScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Feature.CHARACTERS.route
    ) {
        charactersScreenNavigation(navController)
    }
}

private fun NavGraphBuilder.charactersScreenNavigation(navController: NavController) {

    navigation(
        startDestination = NavigationItem.ContentMain(Feature.CHARACTERS).route,
        route = Feature.CHARACTERS.route
    ) {

        composable(NavigationItem.ContentMain(Feature.CHARACTERS)) {
            CharactersScreen(
                onClick = { character ->
                    navController.navigate(
                        NavigationItem.ContentDetail(Feature.CHARACTERS).createRoute(character.id)
                    )
                }
            )
        }

        composable(NavigationItem.ContentDetail(Feature.CHARACTERS)) {
            val id = it.findArgument<Int>(NavigationArgument.Id)
            CharacterDetailScreen(
                id = id,
                onUpClick = { navController.popBackStack() }
            )
        }
    }
}

private fun NavGraphBuilder.composable(
    navigationItem: NavigationItem,
    content: @Composable (NavBackStackEntry) -> Unit
) {
    composable(
        route = navigationItem.route,
        arguments = navigationItem.arguments
    ) {
        content(it)
    }
}

private inline fun <reified T> NavBackStackEntry.findArgument(
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
