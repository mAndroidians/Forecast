package com.awsm.forecastapp

import androidx.multidex.MultiDex
import com.awsm.forecastapp.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber

class ForeCastApplication : DaggerApplication() {
    override fun onCreate() {
        super.onCreate()

        MultiDex.install(this)
        Timber.plant(Timber.DebugTree())
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder()
            .create(this)
            .build()
    }
}