package com.clp3z.marvelcompose.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.clp3z.marvelcompose.ui.navigation.Navigation
import com.clp3z.marvelcompose.ui.navigation.navigateAndPopToStartDestination
import com.clp3z.marvelcompose.ui.theme.MarvelComposeTheme
import com.clp3z.marvelcompose.ui.views.BottomNavigation

@Composable
fun MarvelApplication() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: ""

    MarvelScreen {
        Scaffold(
            bottomBar = {
                BottomNavigation(
                    currentRoute = currentRoute,
                    onNavigationItemClicked = {
                        navController.navigateAndPopToStartDestination(it)
                    }
                )
            }
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
