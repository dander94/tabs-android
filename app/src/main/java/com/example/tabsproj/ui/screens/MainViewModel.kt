package com.example.tabsproj.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

open class MainViewModel: ViewModel() {
    fun launchService (
        func: suspend CoroutineScope.() -> Unit,
        onError: (e: Throwable?) -> Unit
    ) {
        viewModelScope.launch (
            CoroutineExceptionHandler {
                _, e -> onError(e)
            },
            block = func,
        )
    }
}