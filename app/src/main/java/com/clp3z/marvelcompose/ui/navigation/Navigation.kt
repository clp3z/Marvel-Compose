package com.clp3z.marvelcompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.navigation
import com.clp3z.marvelcompose.ui.screens.characters.CharacterDetailScreen
import com.clp3z.marvelcompose.ui.screens.characters.CharactersScreen
import com.clp3z.marvelcompose.ui.screens.comics.ComicDetailScreen
import com.clp3z.marvelcompose.ui.screens.comics.ComicsScreen
import com.clp3z.marvelcompose.ui.screens.events.EventDetailScreen
import com.clp3z.marvelcompose.ui.screens.events.EventsScreen

@Composable
fun Navigation(navController: NavHostController) {
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
        startDestination = NavigationCommand.ContentMain(Feature.CHARACTERS).route,
        route = Feature.CHARACTERS.route
    ) {

        composable(NavigationCommand.ContentMain(Feature.CHARACTERS)) {
            CharactersScreen(
                onClick = { character ->
                    navController.navigate(
                        NavigationCommand.ContentDetail(Feature.CHARACTERS).createRoute(character.id)
                    )
                }
            )
        }

        composable(NavigationCommand.ContentDetail(Feature.CHARACTERS)) {
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
        startDestination = NavigationCommand.ContentMain(Feature.COMICS).route,
        route = Feature.COMICS.route
    ) {

        composable(NavigationCommand.ContentMain(Feature.COMICS)) {
            ComicsScreen(
                onClick = { character ->
                    navController.navigate(
                        NavigationCommand.ContentDetail(Feature.COMICS).createRoute(character.id)
                    )
                }
            )
        }

        composable(NavigationCommand.ContentDetail(Feature.COMICS)) {
            val id = it.findArgument<Int>(NavigationArgument.Id)
            ComicDetailScreen(
                id = id,
                onUpClick = { navController.popBackStack() }
            )
        }
    }
}

private fun NavGraphBuilder.eventsScreenNavigation(navController: NavController) {

    navigation(
        startDestination = NavigationCommand.ContentMain(Feature.EVENTS).route,
        route = Feature.EVENTS.route
    ) {

        composable(NavigationCommand.ContentMain(Feature.EVENTS)) {
            EventsScreen(
                onClick = { character ->
                    navController.navigate(
                        NavigationCommand.ContentDetail(Feature.EVENTS).createRoute(character.id)
                    )
                }
            )
        }

        composable(NavigationCommand.ContentDetail(Feature.EVENTS)) {
            val id = it.findArgument<Int>(NavigationArgument.Id)
            EventDetailScreen(
                id = id,
                onUpClick = { navController.popBackStack() }
            )
        }
    }
}
