package com.lcabral.core.data.remote.di

import com.lcabral.core.data.remote.BuildConfig
import com.lcabral.core.data.remote.HttpClient
import com.lcabral.core.data.remote.HttpClientImpl
import com.lcabral.core.data.remote.RetrofitClient
import com.lcabral.core.data.remote.interceptor.AuthInterceptor
import com.lcabral.core.data.remote.interceptor.HeaderInterceptor
import okhttp3.Interceptor
import org.koin.dsl.module
import okhttp3.logging.HttpLoggingInterceptor

val dataModule = module {
    single<HttpClient> {
        HttpClientImpl(
            retrofit = getRetrofitClient().create()
        )
    }
}

fun getRetrofitClient(): RetrofitClient {
    return RetrofitClient(
        interceptors = listOf(
            AuthInterceptor(apiKey = BuildConfig.API_KEY),
            HeaderInterceptor(),
            httpLoggingInterceptor()
        )
    )
}

private fun httpLoggingInterceptor(): Interceptor =
    HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else HttpLoggingInterceptor.Level.NONE
    }