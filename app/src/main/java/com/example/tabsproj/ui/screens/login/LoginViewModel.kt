package com.example.tabsproj.ui.screens.login

import com.example.tabsproj.ui.screens.MainViewModel
import androidx.lifecycle.viewModelScope
import com.example.tabsproj.model.User
import com.example.tabsproj.model.services.AccountService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val accountService: AccountService,
): MainViewModel() {
    val currentUser: User?
        get() = accountService.currentUser

    fun signInAnonymously (onSuccess: () -> Unit, onError: () -> Unit) {
        launchService(
            {
                accountService.signUpAnonymous()
                onSuccess()
            },
            { onError() }
        )
    }
}