package com.lcabral.core.data.remote

interface HttpClient {
    fun <T> create(clazz: Class<T>): T
}
