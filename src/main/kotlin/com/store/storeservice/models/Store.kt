package com.store.storeservice.models

import org.bson.types.ObjectId
import org.jetbrains.annotations.NotNull
import org.springframework.beans.factory.annotation.Required
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.lang.NonNull
import javax.validation.constraints.NotBlank


@Document(collection = "stores")
data class Store(


    @Id
    @NotBlank(message = "id must be entered")
    var id: Int? = null,

    @NotBlank(message = "name must be entered")
    var name: String? = null,
    @NotBlank(message = "status must be entered")
    var status: String? = null,

    var addressPeriod: ArrayList<AddressPeriod>? = null

)

data class AddressPeriod(
    @NotNull
    var dateValidFrom: String? = null,
    @NotNull
    var dateValidUntil: String? = null,

    var storeAddress: StoreAddress? = null


)

data class StoreAddress(
    var street: String? = null,
    var houseNumber: String? = null,
    var houseNumberSuffix: String? = null,
    var postalCode: String? = null,
    var city: String? = null,
    var country: String? = null
)
