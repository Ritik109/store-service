package com.store.storeservice.repositories

import com.store.storeservice.models.Store
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository


@Repository
interface StoreRepositories : MongoRepository<Store, Int> {
}