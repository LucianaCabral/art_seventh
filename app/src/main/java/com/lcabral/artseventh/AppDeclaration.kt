package com.lcabral.artseventh

import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level
import org.koin.dsl.KoinAppDeclaration

object AppDeclaration {

    fun get(application: Application): KoinAppDeclaration = {
        androidLogger(Level.ERROR)
        androidContext(application)
    }
}
