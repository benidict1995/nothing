package com.metromart.domain.exception.model

data class ErrorResponse(
    val message: String? = null,
    val exception: Throwable?= null
)