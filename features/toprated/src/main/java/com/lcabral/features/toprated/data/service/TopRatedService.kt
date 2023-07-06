package com.lcabral.features.toprated.data.service

import com.lcabral.features.toprated.data.model.TopRatedResult
import retrofit2.http.GET

internal interface TopRatedService {
    @GET("/3/movie/top_rated")
    suspend fun getTopRated(): TopRatedResult
}
