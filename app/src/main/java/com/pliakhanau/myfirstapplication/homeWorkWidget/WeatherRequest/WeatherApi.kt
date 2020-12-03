package com.pliakhanau.myfirstapplication.homeWorkWidget.WeatherRequest


import com.pliakhanau.myfirstapplication.homeWorkWidget.dto.WeatherResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherApi {

    @GET("data/2.5/weather?appid=066684c224288ec83f079c8017eb1057&lang=ru&units=metric")
    fun getWeather(@Query("q") city: String): Deferred<Response<WeatherResponse>>
}

// https://api.openweathermap.org/data/2.5/weather?appid=066684c224288ec83f079c8017eb1057&lang=ru&units=metric&q=Minsk