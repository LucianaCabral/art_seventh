package com.lcabral.features.dashboard.di

import com.lcabral.core.common.navigation.DashboardNavigation
import com.lcabral.features.dashboard.navigation.DashBoardNavigationImpl
import org.koin.core.module.Module
import org.koin.dsl.module

object DashboardModule {
    val modules get() = listOf(additionalModules)

    private val additionalModules: Module = module {
        factory<DashboardNavigation> { DashBoardNavigationImpl() }
    }
}
