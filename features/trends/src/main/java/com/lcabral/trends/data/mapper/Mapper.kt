package com.lcabral.trends.data.mapper

interface Mapper<S,T> {
    fun map(source:S):T
}
