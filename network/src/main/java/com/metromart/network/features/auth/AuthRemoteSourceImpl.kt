package com.metromart.network.features.auth

import com.metromart.domain.features.auth.User
import com.metromart.domain.util.dispatcherIO
import com.metromart.network.features.auth.mapper.AuthMapper.mapToUserList
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRemoteSourceImpl @Inject constructor(
    private val authService: AuthService
): AuthRemoteSource{
    override suspend fun loadUserList(): List<User> = withContext(dispatcherIO){
        authService.loadUserList().mapToUserList()
    }
}