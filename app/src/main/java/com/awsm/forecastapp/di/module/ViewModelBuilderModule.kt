/*
 * Copyright (c) 2019. REDIFLEX CONSULTING PRIVATE LIMITED
 */

package com.awsm.forecastapp.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.awsm.forecastapp.di.DaggerViewModelFactory
import com.awsm.forecastapp.di.ViewModelKey
import com.awsm.forecastapp.fragments.TodayViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelBuilderModule {
	@Binds
	@IntoMap
	@Provides
	@ViewModelKey(TodayViewModel::class )
	internal abstract fun bindTodayViewModel(todayViewModel: TodayViewModel): ViewModel

	@Binds
	internal abstract fun bindViewModelFactory(viewModelFactory: DaggerViewModelFactory): ViewModelProvider.Factory

}