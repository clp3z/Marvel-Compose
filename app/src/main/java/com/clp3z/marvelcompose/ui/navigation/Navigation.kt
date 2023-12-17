package com.clp3z.marvelcompose.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.clp3z.marvelcompose.R
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
        settingsScreen()
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
            CharacterDetailScreen()
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
            ComicDetailScreen(id = id)
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
            EventDetailScreen(id = id)
        }
    }
}

private fun NavGraphBuilder.settingsScreen() {
    composable(NavigationCommand.ContentMain(Feature.SETTINGS).route) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(id = R.string.settings),
                style = MaterialTheme.typography.h3
            )
        }
    }
}
