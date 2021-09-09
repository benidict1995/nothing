package com.metromart.domain.features.auth

data class User(
    val id: String,
    val name: String,
    val username: String,
    val email: String,
    val phone: String,
    val website: String
)