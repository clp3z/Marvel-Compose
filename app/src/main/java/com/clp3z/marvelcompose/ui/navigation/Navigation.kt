package com.clp3z.marvelcompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.clp3z.marvelcompose.ui.screens.characters.CharacterDetailScreen
import com.clp3z.marvelcompose.ui.screens.characters.CharactersScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Feature.CHARACTERS.route
    ) {
        charactersScreenNavigation(navController)
        comicsScreenNavigation(navController)
        eventsScreenNavigation(navController)
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

private fun NavGraphBuilder.comicsScreenNavigation(navController: NavController) {

    navigation(
        startDestination = NavigationItem.ContentMain(Feature.COMICS).route,
        route = Feature.COMICS.route
    ) {

        composable(NavigationItem.ContentMain(Feature.COMICS)) {
            CharactersScreen(
                onClick = { character ->
                    navController.navigate(
                        NavigationItem.ContentDetail(Feature.COMICS).createRoute(character.id)
                    )
                }
            )
        }

        composable(NavigationItem.ContentDetail(Feature.COMICS)) {
            val id = it.findArgument<Int>(NavigationArgument.Id)
            CharacterDetailScreen(
                id = id,
                onUpClick = { navController.popBackStack() }
            )
        }
    }
}

private fun NavGraphBuilder.eventsScreenNavigation(navController: NavController) {

    navigation(
        startDestination = NavigationItem.ContentMain(Feature.EVENTS).route,
        route = Feature.EVENTS.route
    ) {

        composable(NavigationItem.ContentMain(Feature.EVENTS)) {
            CharactersScreen(
                onClick = { character ->
                    navController.navigate(
                        NavigationItem.ContentDetail(Feature.EVENTS).createRoute(character.id)
                    )
                }
            )
        }

        composable(NavigationItem.ContentDetail(Feature.EVENTS)) {
            val id = it.findArgument<Int>(NavigationArgument.Id)
            CharacterDetailScreen(
                id = id,
                onUpClick = { navController.popBackStack() }
            )
        }
    }
}

