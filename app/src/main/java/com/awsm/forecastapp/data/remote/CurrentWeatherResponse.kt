package com.awsm.forecastapp.data.remote


data class CurrentWeatherResponse(
    val current: Current,
    val location: Location
)