package com.example.tabsproj.model.services

import com.example.tabsproj.model.User
import com.google.firebase.auth.AuthResult

interface AccountService {
    val currentUser: User?

    suspend fun isAnonymous (): Boolean
    suspend fun linkAccount ()
    suspend fun signUpAnonymous (): AuthResult
    suspend fun signInGoogle ()
    fun signOut ()
}