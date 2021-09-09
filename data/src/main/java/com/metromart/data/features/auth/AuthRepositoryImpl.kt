package com.metromart.data.features.auth

import com.metromart.domain.features.auth.User
import com.metromart.local.features.auth.AuthLocalSource
import com.metromart.network.features.auth.AuthRemoteSource
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authRemoteSource: AuthRemoteSource,
    private val authLocalSource: AuthLocalSource
) : AuthRepository {

    override suspend fun loadIsUserOnboarded(): Boolean = authLocalSource.loadIsUserOnboarded()

    override suspend fun saveUserOnboarded(): Boolean = authLocalSource.saveUserOnboarded()

    override suspend fun loadUserList(): List<User> {
        return authRemoteSource.loadUserList()
    }

    override suspend fun loadIsUserLoggedIn(): Boolean {
       return authLocalSource.loadIsUserLoggedIn()
    }

    override suspend fun saveUserLoggedIn(): Boolean {
        return authLocalSource.saveUserLoggedIn()
    }

}