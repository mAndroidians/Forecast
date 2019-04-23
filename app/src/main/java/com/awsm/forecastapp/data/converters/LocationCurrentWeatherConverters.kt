package com.awsm.forecastapp.data.typeConverter

import androidx.room.TypeConverter
import com.awsm.forecastapp.data.remote.CurrentWeatherEntity
import com.google.gson.Gson

class LocationCurrentWeatherConverters {

    @TypeConverter
    fun anyToString(value: CurrentWeatherEntity?): String? {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun fromString(value: String?): CurrentWeatherEntity? {
        return Gson().fromJson(value, CurrentWeatherEntity::class.java)
    }
}