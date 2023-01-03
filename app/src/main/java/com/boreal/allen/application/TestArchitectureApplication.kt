package com.boreal.allen.application

import android.app.Application
import com.boreal.allen.home.di.homeModule
import com.boreal.allen.profile.di.profileModule
import com.boreal.commonutils.application.CUAppInit
import org.koin.core.context.startKoin

class TestArchitectureApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                homeModule,
                profileModule
            )
        }
        CUAppInit.init(this, applicationContext)
    }
}