package com.clp3z.marvelcompose.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.PeopleAlt
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.clp3z.marvelcompose.R

enum class NavigationItem(
    @StringRes val title: Int,
    val icon: ImageVector,
    val command: NavigationCommand
) {
    CHARACTERS(
        title = R.string.characters,
        icon = Icons.Default.PeopleAlt,
        command = NavigationCommand.ContentMain(Feature.CHARACTERS)
    ),
    COMICS(
        title = R.string.comics,
        icon = Icons.Default.MenuBook,
        command = NavigationCommand.ContentMain(Feature.COMICS)
    ),
    EVENTS(
        title = R.string.events,
        icon = Icons.Default.Event,
        command = NavigationCommand.ContentMain(Feature.EVENTS)
    );
}

sealed class NavigationCommand(
    internal val feature: Feature,
    internal val subRoute: String = "home",
    private val navigationArguments: List<NavigationArgument> = emptyList()
) {
    val route = run {
        val arguments = navigationArguments.map { "{${it.key}}" }
        listOf(feature.route)
            .plus(subRoute)
            .plus(arguments)
            .joinToString(separator = "/")
    }

    val arguments = navigationArguments.map {
        navArgument(it.key) { type = it.navType }
    }

    class ContentMain(feature: Feature) : NavigationCommand(feature)

    class ContentDetail(
        feature: Feature
    ) : NavigationCommand(feature, "detail", listOf(NavigationArgument.Id)) {

        fun createRoute(id: Int) = "${feature.route}/$subRoute/$id"
    }
}

enum class NavigationArgument(val key: String, val navType: NavType<*>) {
    Id("id", NavType.IntType)
}