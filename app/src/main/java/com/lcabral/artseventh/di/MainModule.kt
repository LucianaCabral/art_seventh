package com.lcabral.artseventh.di

import org.koin.core.module.Module
import org.koin.dsl.module

object MainModule {
   val modules get() = listOf(presentation, domainModule ,dataModule)

    private val dataModule:Module = module {  }
    private val domainModule:Module = module {  }
    private val presentation:Module = module { }
}
