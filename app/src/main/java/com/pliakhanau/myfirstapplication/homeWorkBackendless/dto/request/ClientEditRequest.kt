package com.example.backendless.dto.request

import com.google.gson.annotations.SerializedName

class ClientEditRequest (
    @SerializedName("deposit")
    val deposit: Double? = null,
    @SerializedName("first_name")
    val firstName: String? = null,
    @SerializedName("last_name")
    val lastName: String? = null,
    @SerializedName("objectId")
    val objectId: String? = null
)
