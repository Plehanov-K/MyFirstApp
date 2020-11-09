package com.example.backendless.retrofit

import com.example.backendless.networking.ClientAPI
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

private const val BASE_URL="https:api.backendless.com/ED9E4577-9986-E225-FFBC-1681CAEDEE00/"
object RetrofitFactory {
    private val interceptor =HttpLoggingInterceptor().apply {
        level=HttpLoggingInterceptor.Level.BODY
    }
    private val client=OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()



    fun provideAPI():ClientAPI{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(client)
            .build()
            .create()
    }
}