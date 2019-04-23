package com.awsm.forecastapp.di.module

import com.awsm.forecastapp.fragments.SettingFragment
import com.awsm.forecastapp.fragments.SevenDayForcastFragment
import com.awsm.forecastapp.fragments.TodayFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentBuilderModule {

	/**
	 * Common flow fragment list
	 */
	@ContributesAndroidInjector
	abstract fun contributeTodayFragment(): TodayFragment


	@ContributesAndroidInjector
	abstract fun contributeSevenDayForcastFragment():SevenDayForcastFragment

	@ContributesAndroidInjector
	abstract fun contributeSettingFragment():SettingFragment





}