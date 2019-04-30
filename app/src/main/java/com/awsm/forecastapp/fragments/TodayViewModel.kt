package com.awsm.forecastapp.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.awsm.forecastapp.data.ApiService
import com.awsm.forecastapp.data.remote.Current
import com.awsm.forecastapp.data.remote.CurrentWeatherResponse
import com.awsm.forecastapp.data.remote.Location
import com.awsm.forecastapp.data.repo.CurrentWeatherRepository
import com.awsm.forecastapp.data.util.ApiResponse
import javax.inject.Inject

class TodayViewModel @Inject constructor(
    private val apiService:ApiService,
    private val currentWeatherRepository: CurrentWeatherRepository) : ViewModel() {

    val name = MutableLiveData<String>()
    val temperature = MutableLiveData<Double>()

    fun getUserInformation(): LiveData<ApiResponse<CurrentWeatherResponse>> {
        return apiService.getCurrentWeather()
    }


    fun setInformation(location:Location,current: Current) {
        name.postValue(location.country)
        temperature.postValue(current.tempC)
    }

}