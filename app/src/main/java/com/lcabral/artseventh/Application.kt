package com.lcabral.artseventh

import android.app.Application
import com.lcabral.artseventh.di.MainModule.modules
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.module.Module

class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin { AppDeclaration }
        modules.load()
    }

    private fun List<Module>.load() {
        loadKoinModules(modules = this)
    }
}
