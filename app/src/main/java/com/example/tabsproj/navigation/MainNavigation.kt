package com.example.tabsproj.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tabsproj.ui.screens.welcome.WelcomeScreen

enum class AppRoutes(val route: String) {
    HOME("home"),
}

fun NavController.replace(route: String) {
    popBackStack()
    navigate(route)
}

@Composable
private fun MainNavigationGraph (controller: NavHostController) {
    NavHost(
        navController = controller,
        startDestination = AppRoutes.HOME.route
    ) {
        composable(AppRoutes.HOME.route) {
            WelcomeScreen(controller)
        }
    }
}

@Composable
fun MainNavigation () {
    val controller = rememberNavController()
    MainNavigationGraph(controller = controller)
}
