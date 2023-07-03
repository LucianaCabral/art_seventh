package com.lcabral.features.upcoming.di

import org.junit.Test
import org.koin.test.check.checkModules

internal class UpcomingModuleTest {
    @Test
    fun verifyKoinApp() {
        checkModules {
            listOf(modules())
        }
    }
}
