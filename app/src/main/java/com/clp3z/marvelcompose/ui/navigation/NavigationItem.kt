package com.clp3z.marvelcompose.ui.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class NavigationItem(
    internal val baseRoute: String,
    private val navigationArguments: List<NavigationArgument> = emptyList()
) {
    val route = run {
        val arguments = navigationArguments.map { "{${it.key}}" }
        listOf(baseRoute)
            .plus(arguments)
            .joinToString(separator = "/")
    }

    val arguments = navigationArguments.map {
        navArgument(it.key) { type = it.navType }
    }

    object Characters : NavigationItem("characters")

    object CharacterDetail : NavigationItem("characterDetail", listOf(NavigationArgument.Id)) {
        fun createRoute(id: Int) = "$baseRoute/$id"
    }
}

enum class NavigationArgument(val key: String, val navType: NavType<*>) {
    Id("id", NavType.IntType)
}