package com.awsm.forecastapp.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.awsm.forecastapp.data.remote.CurrentWeatherEntity
import com.awsm.forecastapp.data.repo.CurrentWeatherRepository
import com.awsm.forecastapp.data.util.Resource
import javax.inject.Inject

class TodayViewModel @Inject constructor(private val currentWeatherRepository: CurrentWeatherRepository) : ViewModel() {

    val name = MutableLiveData<String>()

    fun getUserInformation(): LiveData<Resource<CurrentWeatherEntity>> {
        return currentWeatherRepository.getCurrentWeather()
    }


    fun setInformation(currentWeatherEntity: CurrentWeatherEntity) {
        name.postValue(currentWeatherEntity.current.condition.toString())
//
//        email.postValue(userEntity.email)
//        if (userEntity.userType == "D") {
//            isDoctor.postValue(true)
//        } else {
//            isDoctor.postValue(false)
//        }
    }

}