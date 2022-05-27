package com.ida.challengechapter7

import android.app.Application
import com.ida.challengechapter7.di.networkModule
import com.ida.challengechapter7.di.repositoryModule
import com.ida.challengechapter7.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApp : Application(){

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainApp)
            modules(
                listOf(networkModule, repositoryModule, viewModelModule)
            )
        }
    }
}