package com.lcabral.trends.di

import org.koin.core.module.Module
import org.koin.dsl.module

object TrendingModule   {
    val modules get() = listOf(domainModule ,dataModule)

    private val dataModule: Module = module {  }
    private val domainModule:Module = module {  }
}
