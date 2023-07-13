package com.lcabral.features.search.domain.usecase

import app.cash.turbine.test
import com.lcabral.features.movies.domain.model.Movie
import com.lcabral.features.search.domain.repository.SearchRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlin.test.assertEquals
import kotlin.time.ExperimentalTime
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Test

@OptIn(ExperimentalTime::class)
internal class SearchUseCaseTest {
    private val searchRepository: SearchRepository = mockk(relaxed = true)
    private val subject = SearchMoviesUseCase(searchRepository)

    @Test
    fun `SearchMovies Should return movies`() = runBlocking {
        // Given
        val query = "query"
        val result = mockk<List<Movie>>()

        every { searchRepository.searchMovies(any()) } returns flow { emit(result) }

        // When
        val searchMovieResult = subject.invoke(query)

        // Then
        searchMovieResult.test {
            verify { searchRepository.searchMovies(query) }
            assertEquals(expectItem(), result)
            expectComplete()
        }
    }
}
