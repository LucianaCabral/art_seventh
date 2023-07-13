package com.lcabral.features.search.data.service

import com.lcabral.features.movies.data.model.MovieResult
import retrofit2.http.GET
import retrofit2.http.Path

internal interface SearchService {
    @GET("/3/search/movie")
    suspend fun searchMovies(@Path("query") query: String): MovieResult
}