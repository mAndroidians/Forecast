package com.awsm.forecastapp.di.component

import android.app.Application
import com.awsm.forecastapp.ForeCastApplication
import com.awsm.forecastapp.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

import javax.inject.Singleton

@Singleton
@Component(
	modules = [
		AndroidSupportInjectionModule::class,
		ActivityBuilderModule::class,
		ApiServiceModule::class,
		FragmentBuilderModule::class,
		NetworkModule::class,
		DatabaseModule::class,
		ViewModelBuilderModule::class,
		SharedPreferencesModule::class
	]
)
interface AppComponent : AndroidInjector<ForeCastApplication> {
	@Component.Builder
	interface Builder {

		@BindsInstance
		fun create(application: Application): AppComponent.Builder

		fun build(): AppComponent
	}
}