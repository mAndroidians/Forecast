package com.awsm.forecastapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.awsm.forecastapp.data.remote.CurrentWeatherEntity

@Dao
interface CurrentWeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(currentWeatherEntity: CurrentWeatherEntity)

    @Query("SELECT * FROM current_weather_table")
    fun getCurrentWeather(): LiveData<CurrentWeatherEntity>

    @Query("DELETE FROM current_weather_table")
    fun deleteAll()
}