package com.ibrahim.dev.localbitcoinutils.app

import android.app.Application
import com.ibrahim.dev.localbitcoinutils.app.di.retrofitModule
import com.ibrahim.dev.localbitcoinutils.app.di.serviceModule
import com.ibrahim.dev.localbitcoinutils.home.di.homeModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class Application: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger(Level.ERROR)
            androidContext(this@Application)
            modules(listOf(retrofitModule, serviceModule, homeModule))
        }

    }
}