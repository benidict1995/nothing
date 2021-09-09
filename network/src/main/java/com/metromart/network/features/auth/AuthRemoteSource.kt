package com.metromart.network.features.auth

import com.metromart.domain.features.auth.User

interface AuthRemoteSource {
    suspend fun loadUserList(): List<User>
}