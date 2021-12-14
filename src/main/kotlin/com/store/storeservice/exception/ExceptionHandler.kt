package com.store.storeservice.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(StoreNotFoundException::class)
    fun storeNotFound(ex: StoreNotFoundException): ResponseEntity<ErrorModel> {
        return ResponseEntity(
            ErrorModel(
                ex.message,
                HttpStatus.BAD_REQUEST

            ), HttpStatus.BAD_REQUEST
        )
    }

    @ExceptionHandler(StoreAlreadyExistsException::class)
    fun storeAlreadyExists(ex: StoreAlreadyExistsException): ResponseEntity<ErrorModel> {
        return ResponseEntity(
            ErrorModel(
                ex.message,
                HttpStatus.BAD_REQUEST

            ), HttpStatus.BAD_REQUEST
        )
    }

    @ExceptionHandler(InvalidRequestException::class)
    fun invalidRequestException(ex: InvalidRequestException): ResponseEntity<ErrorModel> {
        return ResponseEntity(
            ErrorModel(
                ex.message,
                HttpStatus.BAD_REQUEST

            ), HttpStatus.BAD_REQUEST
        )
    }

    @ExceptionHandler(Exception::class)
    fun genericException(ex: Exception): ResponseEntity<ErrorModel> {
        return ResponseEntity(
            ErrorModel(
                ex.message,
                HttpStatus.INTERNAL_SERVER_ERROR

            ), HttpStatus.INTERNAL_SERVER_ERROR
        )
    }
}