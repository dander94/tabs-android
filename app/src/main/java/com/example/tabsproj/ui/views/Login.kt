package com.example.tabsproj.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Login() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 16.dp)
        ,
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
            TextButton(onClick = { /*TODO*/ }) {
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
    Login()
}
