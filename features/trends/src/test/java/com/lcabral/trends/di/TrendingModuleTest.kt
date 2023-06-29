package com.lcabral.trends.di

import org.junit.Test
import org.koin.test.KoinTest
import org.koin.test.check.checkModules

class TrendingModuleTest : KoinTest {

    @Test
    fun verifyKoinApp() {
        checkModules {
            listOf(modules())
        }
    }
}