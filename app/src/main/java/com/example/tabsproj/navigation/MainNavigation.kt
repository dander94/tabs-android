package com.example.tabsproj.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tabsproj.ui.views.Login
import com.example.tabsproj.ui.views.Welcome

@Composable
private fun MainNavigationGraph (controller: NavHostController) {
    NavHost(
        navController = controller,
        startDestination = "home"
    ) {
        composable("home") {
            Welcome()
        }
        composable("login") {
            Login()
        }
    }
}

@Composable
fun MainNavigation () {
    val controller = rememberNavController()
    MainNavigationGraph(controller = controller)
}
