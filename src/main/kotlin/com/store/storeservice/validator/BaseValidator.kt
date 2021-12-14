package com.store.storeservice.validator

import com.store.storeservice.constants.*
import com.store.storeservice.exception.InvalidRequestException
import com.store.storeservice.models.Store
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class BaseValidator {

    fun validatePostRequestSchema(store : Store){
        store.id ?: throw InvalidRequestException(STORE_ID_REQUIRED_MESSAGE)
        store.name ?: throw InvalidRequestException(STORE_NAME_REQUIRED_MESSAGE)
        store.status ?: throw InvalidRequestException(STORE_STATUS_REQUIRED_MESSAGE)



    }
}