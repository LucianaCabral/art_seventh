package com.lcabral.trends.data.service

import com.lcabral.trends.data.model.TrendingsResult
import retrofit2.http.GET

internal interface TrendingService {
    @GET("/3/movie/trendings")
    suspend fun getTrendings(): TrendingsResult
}
