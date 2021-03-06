package com.awsm.forecastapp.di.module

import com.awsm.forecastapp.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilderModule {

	@ContributesAndroidInjector
	abstract fun contributeMainActivity(): MainActivity


}