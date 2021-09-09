package com.metromart.local.features.auth

import android.util.Log
import com.metromart.domain.util.dispatcherIO
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthLocalSourceImpl @Inject constructor(
    private val authLocalService: AuthLocalService
) : AuthLocalSource{

    override suspend fun saveUserOnboarded(): Boolean = withContext(dispatcherIO){
        authLocalService.saveUserOnboarded()
    }

    override suspend fun loadIsUserOnboarded(): Boolean = withContext(dispatcherIO){
        authLocalService.loadIsUserOnboarded()
    }

    override suspend fun saveUserLoggedIn(): Boolean = withContext(dispatcherIO){
        authLocalService.saveUserLoggedIn()
    }

    override suspend fun loadIsUserLoggedIn(): Boolean = withContext(dispatcherIO){
        authLocalService.loadIsUserLoggedIn()
    }
}