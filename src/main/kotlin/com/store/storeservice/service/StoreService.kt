package com.store.storeservice.service

import com.store.storeservice.exception.StoreAlreadyExistsException
import com.store.storeservice.exception.StoreNotFoundException
import com.store.storeservice.models.Store
import com.store.storeservice.repositories.StoreRepositories
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import com.store.storeservice.constants.STORE_ID_ALREADY_USED
import com.store.storeservice.constants.STORE_NOT_FOUND
import com.store.storeservice.validator.BaseValidator

@Component
class StoreService(
    @Autowired private val storeRepositories: StoreRepositories,
    @Autowired private val baseValidator: BaseValidator
) {

    fun findAllStore(): ResponseEntity<MutableList<Store>> {
        println(storeRepositories.findAll())
        return ResponseEntity(storeRepositories.findAll(), HttpStatus.OK);
    }

    fun findStoreById(storeId: Int): ResponseEntity<Store> {
        val store = storeRepositories.findByIdOrNull(storeId)

        store ?: return ResponseEntity(
            null,
            HttpStatus.NOT_FOUND
        )
        return ResponseEntity(store, HttpStatus.OK)
    }

    fun saveNewStore(storeToSave: Store): ResponseEntity<String> {
        if (storeRepositories.findByIdOrNull(storeToSave.id) != null) {
            throw StoreAlreadyExistsException(STORE_ID_ALREADY_USED)
        }
        val savedStore = storeRepositories.save(storeToSave)
        baseValidator.validatePostRequestSchema(storeToSave)
        return if (savedStore != null) {
            ResponseEntity(
                "Created : $savedStore", HttpStatus.CREATED
            )

        } else {
            ResponseEntity(
                "Failed : $savedStore", HttpStatus.INTERNAL_SERVER_ERROR
            )
        }
    }

    fun updateExistingStore(storeToUpdate: Store): ResponseEntity<String> {
        storeRepositories.findByIdOrNull(storeToUpdate.id) ?: throw StoreNotFoundException(STORE_NOT_FOUND)
        baseValidator.validatePostRequestSchema(storeToUpdate)
        val savedStore = storeRepositories.save(storeToUpdate)
        return if (savedStore != null) {
            ResponseEntity(
                "Created : $savedStore", HttpStatus.OK
            )

        } else {
            ResponseEntity(
                "Failed : $savedStore", HttpStatus.INTERNAL_SERVER_ERROR
            )

        }
    }

}