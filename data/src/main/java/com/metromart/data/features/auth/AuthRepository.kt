package com.metromart.data.features.auth

import com.metromart.domain.features.auth.User

interface AuthRepository {
    suspend fun loadUserList(): List<User>

    suspend fun saveUserOnboarded(): Boolean
    suspend fun loadIsUserOnboarded(): Boolean

    suspend fun saveUserLoggedIn(): Boolean
    suspend fun loadIsUserLoggedIn(): Boolean
}