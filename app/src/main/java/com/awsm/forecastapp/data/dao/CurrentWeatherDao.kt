package com.awsm.forecastapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.awsm.forecastapp.data.entity.CurrentWeatherEntity

@Dao
interface CurrentWeatherDao {


    @Insert
    fun insert(currentWeatherEntity: CurrentWeatherEntity)

    @Query("SELECT * FROM current_weather_table")
    fun getCurrentWeather(): LiveData<CurrentWeatherEntity>

    @Query("DELETE FROM current_weather_table")
    fun deleteAll()
}