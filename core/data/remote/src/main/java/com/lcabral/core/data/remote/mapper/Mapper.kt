package com.lcabral.core.data.remote.mapper

interface Mapper<S,T> {
    fun map(source:S):T
}