package com.example.tabsproj.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tabsproj.ui.views.Login
import com.example.tabsproj.ui.views.Welcome

enum class AppRoutes(val route: String) {
    HOME("home"),
    LOGIN("login")
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
            Welcome(controller)
        }
        composable(AppRoutes.LOGIN.route) {
            Login(controller)
        }
    }
}

@Composable
fun MainNavigation () {
    val controller = rememberNavController()
    MainNavigationGraph(controller = controller)
}
