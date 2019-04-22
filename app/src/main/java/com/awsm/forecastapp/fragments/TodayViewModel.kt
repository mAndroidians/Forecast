package com.awsm.forecastapp.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.awsm.forecastapp.data.entity.CurrentWeatherEntity
import com.awsm.forecastapp.data.repo.CurrentWeatherRepository
import javax.inject.Inject

class TodayViewModel @Inject constructor(private val currentWeatherRepository: CurrentWeatherRepository) : ViewModel() {
    private var notesData: LiveData<List<CurrentWeatherEntity>>? = null


}