/*
 * Copyright (c) 2019. REDIFLEX CONSULTING PRIVATE LIMITED
 */

package com.awsm.forecastapp.di.module

import com.awsm.forecastapp.data.ApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
class ApiServiceModule {

	@Provides
	@Singleton
	fun provideRetrofitApiService(retrofit: Retrofit): ApiService {
		return retrofit.create(ApiService::class.java)
	}
}