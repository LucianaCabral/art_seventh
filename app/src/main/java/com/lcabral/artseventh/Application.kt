package com.lcabral.artseventh

import android.app.Application
import com.lcabral.artseventh.di.MainModule.modules
import com.lcabral.features.header.di.HeaderModule
import com.lcabral.features.popular.di.PopularModule
import com.lcabral.features.toprated.di.TopRatedModule
import com.lcabral.features.upcoming.di.UpcomingModule
import com.lcabral.trends.di.TrendingModule
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
        loadKoinModules(
            modules = this +
                    TrendingModule.modules +
                    PopularModule.modules +
                    UpcomingModule.modules +
                    TopRatedModule.modules +
                    HeaderModule.modules
        )
    }
}
