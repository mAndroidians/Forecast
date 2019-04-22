package com.awsm.forecastapp.data.repo

import androidx.lifecycle.LiveData
import com.awsm.forecastapp.data.ApiService
import com.awsm.forecastapp.data.dao.CurrentWeatherDao
import com.awsm.forecastapp.data.entity.CurrentWeatherEntity
import com.awsm.forecastapp.data.remote.CurrentWeatherResponse
import com.awsm.forecastapp.data.util.ApiResponse
import com.awsm.forecastapp.data.util.NetworkBoundResource
import com.awsm.forecastapp.data.util.Resource
import health.smartcare.app.data.util.AppExecutors

import javax.inject.Inject

class CurrentWeatherRepository @Inject constructor(private val appExecutors: AppExecutors,
                                                   private val apiService: ApiService,
                                                   private val currentWeatherDao: CurrentWeatherDao
                                                   ) {


    fun getCurrentWeather(forceFetch: Boolean = true, location: String): LiveData<Resource<CurrentWeatherEntity>> {

        return object : NetworkBoundResource<CurrentWeatherEntity, CurrentWeatherResponse>(appExecutors) {
            override fun saveCallResult(item: CurrentWeatherResponse) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                currentWeatherDao.insert(item.currentWeatherEntry)


            }

            override fun shouldFetch(data: CurrentWeatherEntity?): Boolean {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                return data == null || forceFetch
            }

            override fun loadFromDb(): LiveData<CurrentWeatherEntity> {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                return currentWeatherDao.getCurrentWeather()
            }

            override fun createCall(): LiveData<ApiResponse<CurrentWeatherResponse>> {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                return apiService.getCurrentWeather(location)
            }

        }.asLiveData()
    }


}