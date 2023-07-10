package com.lcabral.features.movies.data.service

import com.lcabral.features.movies.data.model.MovieResult
import retrofit2.http.GET

internal interface MovieService {
    @GET("/3/movie/movie/")
    suspend fun getMovie(): MovieResult
}
