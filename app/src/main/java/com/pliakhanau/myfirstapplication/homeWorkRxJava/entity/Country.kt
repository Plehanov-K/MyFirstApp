package com.example.myapplicationrxjava.entity


data class Country(
    val flagUrl: String,
    val country: String,
    val countryCode: String,
    val date: String,
    val totalConfirmed: Int,
    val totalDeaths: Int,
    val totalRecovered: Int
)