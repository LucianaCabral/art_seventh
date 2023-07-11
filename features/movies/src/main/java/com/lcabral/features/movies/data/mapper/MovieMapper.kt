package com.lcabral.features.movies.data.mapper

import com.lcabral.core.data.remote.mapper.Mapper
import com.lcabral.features.movies.data.model.MovieResponse
import com.lcabral.features.movies.domain.model.Movie

internal class  MovieMapper: Mapper<List<MovieResponse>, List<Movie>> {
    override fun map(source: List<MovieResponse>): List<Movie> = source.map {
        mapPopular(it)
    }

    private fun mapPopular(source: MovieResponse) = Movie(
        id = source.id,
        name = source.name,
        description = source.description.orEmpty(),
        posterPath = source.posterPath.orEmpty(),
    )
}
