package com.example.tabsproj.ui.screens.welcome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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

@Composable
fun WelcomeScreen (
    navController: NavController,
    viewModel: WelcomeViewModel = hiltViewModel()
) {
    // Nav Guards
    LaunchedEffect(viewModel.currentUser) {
        if (viewModel.currentUser == null) {
            viewModel.signInAnonymously{}
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