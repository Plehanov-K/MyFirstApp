package com.example.backendless.dto.response


import com.google.gson.annotations.SerializedName

data class ClientResponse(
    @SerializedName("deposit")
    val deposit: Double? = null,
    @SerializedName("first_name")
    val firstName: String? = null,
    @SerializedName("last_name")
    val lastName: String? = null,
    @SerializedName("objectId")
    val objectId: String? = null,
)