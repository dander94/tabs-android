package com.example.tabsproj.ui.screens.login

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tabsproj.navigation.AppRoutes
import com.example.tabsproj.navigation.replace
import com.google.firebase.auth.ktx.auth


@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    // Login Functions
    fun loginAnon () {
        viewModel.signInAnonymously (
            {
                navController.replace(AppRoutes.HOME.route)
            },
            {
                Toast
                    .makeText(
                        context,
                        "Something went wrong :(",
                        Toast.LENGTH_SHORT
                    )
                    .show()
            }
        )
    }

    fun loginGoogle () {
        // TODO: Implement this
    }

    // Nav Guards
    LaunchedEffect(viewModel.currentUser) {
        if (viewModel.currentUser != null) {
            navController.replace(AppRoutes.HOME.route)
        }
    }

    // UI
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                style = MaterialTheme.typography.titleLarge,
                text = "Welcome!",
            )
            Text(
                modifier = Modifier.padding(top = 16.dp),
                style = MaterialTheme.typography.bodySmall,
                text = "Please, log in with Google ",
            )
            Text(
                style = MaterialTheme.typography.bodySmall,
                text = " or continue anonymously",
            )
        }
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(
                onClick = { /*TODO*/ },
            ) {
                Text(
                    style = MaterialTheme.typography.bodyLarge,
                    text = "Login with Google"
                )
            }
            TextButton(onClick = { loginAnon() }) {
                Text(
                    text = "Continue anonymously"
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewLogin () {
    LoginScreen(rememberNavController())
}
