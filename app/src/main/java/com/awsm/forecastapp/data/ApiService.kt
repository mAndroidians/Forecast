package com.awsm.forecastapp.data

import androidx.lifecycle.LiveData
import com.awsm.forecastapp.BuildConfig
import com.awsm.forecastapp.data.remote.CurrentWeatherResponse
import com.awsm.forecastapp.data.util.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query


//http://api.apixu.com/v1/current.json?key=3825f49c15d84d0f8fd61234192104&q=Paris

const val API_KEY = "3825f49c15d84d0f8fd61234192104"

interface ApiService {

	companion object {
		var baseUrl: String = BuildConfig.BASE_URL
	}


	@GET("current.json")
	fun getCurrentWeather(@Query("q") location: String,@Query("lang") langaugeCode:String = "en"):
			LiveData<ApiResponse<CurrentWeatherResponse>>


}
