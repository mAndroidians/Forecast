package com.awsm.forecastapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.awsm.forecastapp.data.dao.CurrentWeatherDao
import com.awsm.forecastapp.data.remote.CurrentWeatherEntity
import com.awsm.forecastapp.data.typeConverter.LocationCurrentWeatherConverters


@Database(entities = [(CurrentWeatherEntity::class)],version = 1,
    exportSchema = false)
@TypeConverters (LocationCurrentWeatherConverters::class)
abstract class ForeCastDatabase : RoomDatabase() {

    abstract fun currentWeatherDao():CurrentWeatherDao
}