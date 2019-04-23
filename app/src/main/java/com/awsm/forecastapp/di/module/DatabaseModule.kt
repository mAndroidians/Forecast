package com.awsm.forecastapp.di.module

import android.app.Application
import androidx.room.Room
import com.awsm.forecastapp.data.ForeCastDatabase
import com.awsm.forecastapp.data.dao.CurrentWeatherDao
import dagger.Module
import dagger.Provides

import javax.inject.Singleton

@Module
class DatabaseModule {
	@Singleton
	@Provides
	fun provideSmartCareDatabase(application: Application): ForeCastDatabase =
		Room.databaseBuilder(application, ForeCastDatabase::class.java, "forecast_database.db")
			.fallbackToDestructiveMigration()
			.build()



	@Singleton
	@Provides
	fun provideCurrentWeatherDao(database: ForeCastDatabase):CurrentWeatherDao = database.currentWeatherDao()
}
