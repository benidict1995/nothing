package com.metromart.network.features.auth

import com.metromart.network.features.auth.model.UserResponse
import retrofit2.http.GET

interface AuthService {
    @GET("users")
    suspend fun loadUserList(): List<UserResponse>


}