package com.store.storeservice.controller

import com.store.storeservice.repositories.StoreRepositories
import com.store.storeservice.models.Store
import com.store.storeservice.service.StoreService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/store-service/v1")
class StoreController(
    @Autowired private val storeService: StoreService

) {


    @RequestMapping("/stores", method = [RequestMethod.GET])
    fun getAllStores(): ResponseEntity<MutableList<Store>> {
        return storeService.findAllStore()

    }

    @RequestMapping("/stores/{id}", method = [RequestMethod.GET])
    fun getStoreById(@PathVariable id: Int): ResponseEntity<Store> {
        return storeService.findStoreById(id)
    }

    @RequestMapping("/stores", method = [RequestMethod.POST])
    fun saveStoreDetails(
        @RequestBody storeDetails: Store
    ): ResponseEntity<String> {
        println(storeDetails)
        return storeService.saveNewStore(storeDetails)

    }

    @RequestMapping("/stores/{id}", method = [RequestMethod.PUT])
    fun updateStoreDetails(
        @PathVariable id: Int,
        @RequestBody storeDetails: Store
    ): ResponseEntity<String> {
        println(storeDetails)
        return storeService.updateExistingStore(storeDetails)


    }
}