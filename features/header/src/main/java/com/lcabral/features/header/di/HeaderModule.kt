package com.lcabral.features.header.di

import com.lcabral.core.common.navigation.HeaderNavigation
import com.lcabral.core.data.remote.di.dataModule
import com.lcabral.features.header.navigation.HeaderNavigationImpl
import org.koin.core.module.Module
import org.koin.dsl.module

object HeaderModule {
    val modules get() = listOf( dataModule, additionalModules)
}

    private val additionalModules: Module = module {
        factory<HeaderNavigation> { HeaderNavigationImpl() }
    }
