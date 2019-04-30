package com.awsm.forecastapp.data.remote

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(
    tableName = "current_weather_table"
)
data class CurrentWeatherEntity(
    @Embedded
    @PrimaryKey
    @field:SerializedName("location")
    val location: LocationResp,
    @Embedded
    @field:SerializedName("current")
    val current: CurrentResp
)

