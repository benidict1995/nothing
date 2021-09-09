package com.metromart.domain.exception

import com.metromart.domain.exception.model.ErrorResponse
import java.net.SocketException
import java.net.UnknownHostException

@Throws(ServiceException::class)
inline fun <T> apiCall(call: () -> T) = try{
    call()
} catch (e: Exception){
    /**
     * We can add other exception here and also if we want to check the
     * status we can also add here.
    **/
    throw ServiceException(
        when (e){
            is UnknownHostException -> {
                ErrorResponse(
                    message = "No internet connection!",
                    exception = e.cause
                )
            }
            is SocketException -> {
                ErrorResponse(
                    message = e.message,
                    exception = e.cause
                )
            }
            else -> {
                ErrorResponse(
                    message = e.message,
                    exception = e.cause
                )
            }
        }
    )
}