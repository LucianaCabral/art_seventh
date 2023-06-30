package com.lcabral.features.popular.data.service

import com.lcabral.features.popular.data.model.PopularResult
import retrofit2.http.GET

internal interface PopularService {

    @GET("/3/trending/movie/popular")
    suspend fun getPopular(): PopularResult
}