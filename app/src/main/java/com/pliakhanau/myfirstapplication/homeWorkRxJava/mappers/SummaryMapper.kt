package com.example.myapplicationrxjava.mappers

import com.example.myapplicationrxjava.dto.CountryResponse
import com.example.myapplicationrxjava.entity.Country

object SummaryMapper {

    fun map(from: CountryResponse): Country {

        return Country(
            country = from.country.orEmpty(),
            countryCode = from.countryCode.orEmpty(),
            date = from.date.orEmpty(),
            totalConfirmed = from.totalConfirmed ?: 0,
            totalDeaths = from.totalDeaths ?: 0,
            totalRecovered = from.totalRecovered ?: 0,
            flagUrl = from.flagUrl.orEmpty()
        )
    }
}