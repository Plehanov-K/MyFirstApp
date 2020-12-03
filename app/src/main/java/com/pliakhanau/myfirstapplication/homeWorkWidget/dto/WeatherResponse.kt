package com.pliakhanau.myfirstapplication.homeWorkWidget.dto


import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("main")
    val main: Main? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("weather")
    val weather: List<Weather>? = null,
) {
    data class Main(
        @SerializedName("temp")
        val temp: Double? = null,
    )
    data class Weather(
        @SerializedName("description")
        val description: String? = null,
        @SerializedName("icon")
        val icon: String? = null,
    )
}