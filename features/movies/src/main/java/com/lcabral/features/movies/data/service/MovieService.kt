package com.lcabral.features.movies.data.service

import com.lcabral.features.movies.data.model.MovieResult
import retrofit2.http.GET
import retrofit2.http.Path

internal interface MovieService {
    @GET("/3/movie/now_playing")
    suspend fun getMovie(): MovieResult

    @GET("/3/search/movie")
    suspend fun searchMovies(@Path("query") query: String): MovieResult
}
