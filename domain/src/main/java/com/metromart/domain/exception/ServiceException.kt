package com.metromart.domain.exception

import com.metromart.domain.exception.model.ErrorResponse

open class ServiceException(
    errorResponse: ErrorResponse
): RuntimeException(errorResponse.message)