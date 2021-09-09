package com.metromart.network.features.auth.mapper

import com.metromart.domain.features.auth.User
import com.metromart.network.features.auth.model.UserResponse

object AuthMapper {

    fun List<UserResponse>?.mapToUserList(): List<User>{
        return if (this == null) {
            emptyList()
        } else {
            with(this) {
                this.map {
                    User(
                        id = it.id,
                        name = it.name,
                        email = it.email,
                        username = it.username,
                        phone = it.phone,
                        website = it.website
                    )
                }
            }
        }
    }

}