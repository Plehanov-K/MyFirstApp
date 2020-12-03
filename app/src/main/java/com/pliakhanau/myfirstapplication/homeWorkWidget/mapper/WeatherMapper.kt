package com.pliakhanau.myfirstapplication.homeWorkWidget.mapper

import com.pliakhanau.myfirstapplication.homeWorkWidget.dto.WeatherResponse
import com.pliakhanau.myfirstapplication.homeWorkWidget.entity.WeatherInfo

class WeatherMapper {

    fun map(from: WeatherResponse): WeatherInfo {
        return WeatherInfo(
            name = from.name.orEmpty(),
            temp = from.main?.temp ?:0.0,
            description = from.weather?.get(0)?.description.orEmpty(),
            icon = from.weather?.get(0)?.icon.orEmpty()
        )
    }
}