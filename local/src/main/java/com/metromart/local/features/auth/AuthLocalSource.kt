package com.metromart.local.features.auth

interface AuthLocalSource {
    suspend fun saveUserOnboarded(): Boolean
    suspend fun loadIsUserOnboarded(): Boolean

    suspend fun saveUserLoggedIn(): Boolean
    suspend fun loadIsUserLoggedIn(): Boolean
}