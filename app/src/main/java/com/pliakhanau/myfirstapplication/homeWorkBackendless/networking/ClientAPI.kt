package com.example.backendless.networking

import com.example.backendless.dto.request.ClientAddRequest
import com.example.backendless.dto.request.ClientEditRequest
import com.example.backendless.dto.response.ClientResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.*

const val REST_KEY="590E389A-FAED-400B-A064-E50E98438091"
interface ClientAPI {
    //
    //https://api.backendless.com/ED9E4577-9986-E225-FFBC-1681CAEDEE00/590E389A-FAED-400B-A064-E50E98438091/data/Clients
    @GET("{key}/data/Clients")
    fun getALLClientsAsync(
        @Path("key")
        key:String
    ):Deferred<Response<List<ClientResponse>>>


    @DELETE("{key}/data/Clients/{id}")
    fun deleteClientAsync(
        @Path("key")
        key:String,
        @Path("id")
        id:String
    ):Deferred<Response<Unit>>


    @POST("{key}/data/Clients")
    fun addClient(
        @Path("key")
        key:String,
        @Body
        client: ClientAddRequest
    ):Deferred<Response<Unit>>


    @PUT("{key}/data/Clients")
    fun editClient(
        @Path("key")
        key:String,
        @Body
        client: ClientEditRequest
    ):Deferred<Response<Unit>>

}