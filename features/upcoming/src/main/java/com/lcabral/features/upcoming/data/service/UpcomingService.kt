package com.lcabral.features.upcoming.data.service

import com.lcabral.features.upcoming.data.model.UpcomingResult
import retrofit2.http.GET

internal interface UpcomingService {
    @GET("/3/movie/upcoming")
    suspend fun getUpcoming(): UpcomingResult
}
