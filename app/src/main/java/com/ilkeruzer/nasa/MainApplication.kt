package com.ilkeruzer.nasa

import android.app.Application
import com.ilkeruzer.nasa.di.appModule
import com.ilkeruzer.nasa.di.networkModule
import com.ilkeruzer.nasa.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@MainApplication)
            modules(listOf(
                appModule,
                networkModule,
                viewModelModule
            ))
        }
    }
}