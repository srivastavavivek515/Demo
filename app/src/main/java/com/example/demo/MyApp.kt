package com.example.demo

import android.app.Application
import com.example.demo.koin_di.module.carModule
import com.example.demo.koin_di.module.dbModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(carModule, dbModule)
        }

    }
}