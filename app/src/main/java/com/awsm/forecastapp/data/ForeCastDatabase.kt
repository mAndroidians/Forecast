package com.awsm.forecastapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.awsm.forecastapp.data.dao.CurrentWeatherDao
import com.awsm.forecastapp.data.entity.CurrentWeatherEntity


@Database(entities = [(CurrentWeatherEntity::class)],version = 1,
    exportSchema = false)
abstract class ForeCastDatabase : RoomDatabase() {

    abstract fun currentWeatherDao():CurrentWeatherDao
}