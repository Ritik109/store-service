package com.store.storeservice.exception

import com.fasterxml.jackson.annotation.JsonPropertyOrder
import org.springframework.http.HttpStatus


data class ErrorModel(

    private val _message: String?,
    val status: HttpStatus = HttpStatus.BAD_REQUEST,
    val code: Int = status.value()
) {
    val messages: String
        get() = _message ?: "Something wrong"
}

class StoreNotFoundException(override val message: String?) : Exception(message)
class StoreAlreadyExistsException(override val message: String?) : Exception(message)
class InvalidRequestException(override val message: String?) : Exception(message)

