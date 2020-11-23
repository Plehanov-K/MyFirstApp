package com.example.myapplicationrxjava.networking

import com.example.myapplicationrxjava.dto.SummaryResponse
import io.reactivex.Single
import retrofit2.http.GET

interface CovidApi {

    @GET("summary")
    fun getAll(): Single<SummaryResponse>
}