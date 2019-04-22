package com.awsm.forecastapp.data.remote

import com.awsm.forecastapp.data.entity.CurrentWeatherEntity
import com.google.gson.annotations.SerializedName

//data class CurrentWeatherResponse(
//    @field:SerializedName("current")
//    val current: CurrentResp,
//    val location: LocationResp
//)

data class CurrentWeatherResponse(val currentWeatherEntry: CurrentWeatherEntity)