package com.lcabral.features.movies.domain.usecase

import com.lcabral.features.movies.domain.model.Movie
import com.lcabral.features.movies.domain.repository.MovieRepository
import io.mockk.Called
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.flow.flow
import org.junit.Test


internal class MovieUseCaseTest {
    private val movieRepository: MovieRepository = mockk(relaxed = true)
    private val subject = GetMovieUseCase(movieRepository)

    @Test
    fun `getTrendings Should return trendings movies`() {
        // Given
        val result: List<Movie> = listOf(
            mockk(relaxed = true),
            mockk(relaxed = true),
            mockk(relaxed = true)
        )

        every { movieRepository.getMovies() } returns flow { emit(result) }

        // When
        subject.invoke()

        // Then
        verify { movieRepository.getMovies() }
    }

    @Test
    fun `getTrendings not  Should return trendings movies`() {
        // Given
        every { movieRepository.getMovies() } returns flow { emit(emptyList()) }

        // When
        subject.invoke()

        // Then
        verify { movieRepository.getMovies().wasNot(Called) }
    }
}
