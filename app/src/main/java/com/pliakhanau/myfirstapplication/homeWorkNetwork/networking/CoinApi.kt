package com.pliakhanau.myfirstapplication.homeWorkNetwork.networking

import com.pliakhanau.myfirstapplication.homeWorkNetwork.dto.CoinResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface CoinApi {

        @GET("v1/cryptocurrency/listings/latest")
        fun getRates(
        ): Deferred<Response<CoinResponse>>

}