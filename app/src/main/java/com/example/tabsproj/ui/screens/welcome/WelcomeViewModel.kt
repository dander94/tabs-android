package com.example.tabsproj.ui.screens.welcome

import com.example.tabsproj.ui.screens.MainViewModel
import com.example.tabsproj.model.User
import com.example.tabsproj.model.services.AccountService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val accountService: AccountService,
): MainViewModel() {
    val currentUser: User?
        get() = accountService.currentUser

    fun signInAnonymously (onError: () -> Unit) {
        launchService(
            {
                accountService.signUpAnonymous()
            },
            { onError() }
        )
    }
}