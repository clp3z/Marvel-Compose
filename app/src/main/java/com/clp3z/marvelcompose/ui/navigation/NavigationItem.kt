package com.clp3z.marvelcompose.ui.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class NavigationItem(
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

    class ContentMain(feature: Feature) : NavigationItem(feature)

    class ContentDetail(
        feature: Feature
    ) : NavigationItem(feature, "detail", listOf(NavigationArgument.Id)) {

        fun createRoute(id: Int) = "${feature.route}/$subRoute/$id"
    }
}

enum class NavigationArgument(val key: String, val navType: NavType<*>) {
    Id("id", NavType.IntType)
}