package com.awsm.forecastapp.data.repo

import androidx.lifecycle.LiveData
import com.awsm.forecastapp.data.ApiService
import com.awsm.forecastapp.data.dao.CurrentWeatherDao
import com.awsm.forecastapp.data.remote.CurrentWeatherEntity
import com.awsm.forecastapp.data.remote.CurrentWeatherResponse
import com.awsm.forecastapp.data.util.ApiResponse
import com.awsm.forecastapp.data.util.NetworkBoundResource
import com.awsm.forecastapp.data.util.Resource
import health.smartcare.app.data.util.AppExecutors

import javax.inject.Inject

class CurrentWeatherRepository @Inject constructor(private val appExecutors: AppExecutors,
                                                   private val apiService: ApiService,
                                                   private val currentWeatherDao: CurrentWeatherDao) {

/*

    fun getCurrentWeather(): LiveData<Resource<CurrentWeatherEntity>> {
        return object : NetworkBoundResource<CurrentWeatherEntity, CurrentWeatherResponse>(appExecutors) {
            override fun saveCallResult(item: CurrentWeatherResponse) {
                    currentWeatherDao.deleteAll()
                val res = item
                  //  currentWeatherDao.insert(CurrentWeatherEntity(location = item.location,current = item!!.current))
            }
            override fun shouldFetch(data: CurrentWeatherEntity?): Boolean = true

            override fun loadFromDb(): LiveData<CurrentWeatherEntity> {
                return currentWeatherDao.getCurrentWeather()
            }
            override fun createCall(): LiveData<ApiResponse<CurrentWeatherResponse>> {
                return apiService.getCurrentWeather()
            }
        }.asLiveData()
    }
*/


}