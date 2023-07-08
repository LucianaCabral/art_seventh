package com.lcabral.features.dashboard.di

import org.junit.Test
import org.koin.test.KoinTest
import org.koin.test.check.checkModules

internal class DashBoardModuleTest : KoinTest {

    @Test
    fun verifyKoinApp() {
        checkModules {
            listOf(modules())
        }
    }
}
