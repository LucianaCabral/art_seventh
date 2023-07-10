package com.lcabral.features.movies.domain.usecase

import com.lcabral.features.movies.domain.model.Movie
import com.lcabral.features.movies.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

internal class GetMovieUseCase(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(): Flow<List<Movie>> {
        return movieRepository.getMovies()
    }
}
