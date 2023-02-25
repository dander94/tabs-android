package com.example.tabsproj.model.services.impl

import com.example.tabsproj.model.User
import com.example.tabsproj.model.services.AccountService
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AccountServiceImpl @Inject constructor(private val auth: FirebaseAuth): AccountService {
    override val currentUser: User?
        get() = auth.currentUser?.let { User(it.uid, it.isAnonymous) }

    override suspend fun isAnonymous(): Boolean {
        return this.currentUser?.isAnonymous!!
    }

    override suspend fun linkAccount() {
        TODO("Not yet implemented")
    }

    override suspend fun signUpAnonymous(): AuthResult {
       return auth.signInAnonymously().await()
    }

    override fun signOut() {
        return auth.signOut()
    }

}