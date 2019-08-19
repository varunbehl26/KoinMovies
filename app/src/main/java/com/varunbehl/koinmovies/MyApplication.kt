package com.varunbehl.koinmovies

import android.app.Application
import com.varunbehl.koinmovies.di.ApiModule
import com.varunbehl.koinmovies.di.MovieModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(listOf(ApiModule, MovieModule))
        }
    }
}
