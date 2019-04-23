package com.awsm.forecastapp.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.awsm.forecastapp.di.DaggerViewModelFactory
import com.awsm.forecastapp.di.SmartCareViewModelFactory
import com.awsm.forecastapp.di.ViewModelKey
import com.awsm.forecastapp.fragments.TodayViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelBuilderModule {
	@Binds
	@IntoMap
	@ViewModelKey(TodayViewModel::class )
	internal abstract fun bindTodayViewModel(todayViewModel: TodayViewModel): ViewModel

	@Binds
	internal abstract fun bindViewModelFactory(viewModelFactory: SmartCareViewModelFactory): ViewModelProvider.Factory

}