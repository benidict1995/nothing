package com.metromart.network.features.auth.model

import com.metromart.domain.features.auth.User
import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    val id: String,
    val name: String,
    val username: String,
    val email: String,
    val phone: String,
    val website: String
)
/**
 * If you guys want to remove the mapper object we can do this kind of mapping
 * but for me it is much better to have a mapper object base on our api design,
 * if the api is a flat response this is the best way to mapped the data but in
 * our case I'll go to the mapper object.
 **/

/**
 * Uncomment if you want to try this one
 **/

/**
fun List<UserResponse>?.toDomain(): List<User> {
    return if (this == null) {
        emptyList()
    } else {
        with(this) {
            this.map {
                User(
                    id = it.id,
                    name = it.name,
                    username = it.username,
                    email = it.email,
                    phone = it.phone,
                    website = it.website
                )
            }
        }
    }
}**/