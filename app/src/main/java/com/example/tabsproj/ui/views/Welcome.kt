package com.example.tabsproj.ui.views

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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tabsproj.navigation.AppRoutes
import com.example.tabsproj.navigation.replace
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

private lateinit var auth: FirebaseAuth

@Composable
fun Welcome (navController: NavController) {
    auth = Firebase.auth
    val user = auth.currentUser

    // Functions
    fun onLogout () {
        auth.signOut()
        return navController.replace(AppRoutes.LOGIN.route)
    }

    // Nav Guards
    LaunchedEffect(user) {
        if (user == null) {
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
    Welcome(rememberNavController())
}