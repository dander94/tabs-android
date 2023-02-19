package com.example.tabsproj.ui.screens.welcome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tabsproj.navigation.AppRoutes
import com.example.tabsproj.navigation.replace

@Composable
fun WelcomeScreen (
    navController: NavController,
    viewModel: WelcomeViewModel = hiltViewModel()
) {
    // Functions
    fun onLogout () {
        viewModel.signOut()
        navController.replace(AppRoutes.LOGIN.route)
    }

    // Nav Guards
    LaunchedEffect(viewModel.currentUser) {
        if (viewModel.currentUser == null) {
            navController.replace(AppRoutes.LOGIN.route)
        }
    }

    // UI
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Welcome logged user!"
        )
        Button (
            modifier = Modifier
                .padding(top = 24.dp),
            onClick = { onLogout() }
        ) {
            Text(
                text = "Logout"
            )
        }
    }
}

@Preview
@Composable
fun PreviewWelcome () {
    WelcomeScreen(
        rememberNavController(),
        hiltViewModel(),
    )
}