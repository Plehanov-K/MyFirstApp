package com.example.backendless.mappers

import com.example.backendless.dto.response.ClientResponse
import com.example.backendless.entity.Client

class ClientMappers {

    fun convert(from:ClientResponse):Client{
        with(from){
            return Client(
                deposit ?: 0.0,
                firstName.orEmpty(),
                lastName.orEmpty(),
                objectId.orEmpty(),
            )
        }
    }
}