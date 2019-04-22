/*
 * Copyright (c) 2019. REDIFLEX CONSULTING PRIVATE LIMITED
 */

package com.awsm.forecastapp.di.module

import android.app.Application
import com.awsm.forecastapp.util.SharedPreferencesUtility
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SharedPreferencesModule {
	@Provides
	@Singleton
	fun provideSharedPreferencesModule(application: Application): SharedPreferencesUtility {
		return SharedPreferencesUtility(application)
	}
}