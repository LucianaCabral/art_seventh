package com.lcabral.features.movies.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.lcabral.features.movies.domain.usecase.GetMovieUseCase
import com.lcabral.features.movies.presentation.MovieTestData.getMovies
import com.lcabral.features.movies.presentation.viewmodel.MovieStateView
import com.lcabral.features.movies.presentation.viewmodel.MovieViewModel
import io.mockk.clearAllMocks
import io.mockk.clearMocks
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.mockk.verifyOrder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
internal class MovieViewModelTest {

    @get:Rule
    val testRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    private var initialState = MovieStateView()
    private var getMovieUseCase: GetMovieUseCase = mockk(relaxed = true)
    private val stateObserver: Observer<MovieStateView> = mockk(relaxed = true)
    private lateinit var subject: MovieViewModel
    private val moviesResult = getMovies()

    @Before
    fun setup() {
        subject = MovieViewModel(getMovieUseCase)
        Dispatchers.setMain(Dispatchers.Unconfined)
        subject.viewState.observeForever(stateObserver)
    }

    @After
    fun tearDown() {
        subject.viewState.removeObserver(stateObserver)
        clearAllMocks()
    }

    @Test
    fun `init Should initfetch movies`() = runTest {
        // GIVEN
        clearMocks(stateObserver)
        val expectedFirstState = initialState.copy(
            isLoading = true, moviesFailure = false, getMoviesResultItems = null)
        val expectedSecondState = expectedFirstState.copy(isLoading = false,
            moviesFailure = false, getMoviesResultItems = moviesResult)
        every { getMovieUseCase.invoke() } returns flow { emit(moviesResult) }

        // WHEN
        subject.getMovies()

        // THEN
        verifyOrder {
            stateObserver.onChanged(expectedFirstState)
            stateObserver.onChanged(expectedSecondState)
        }
        coVerify { getMovieUseCase.invoke() }
    }

    @Test
    fun `init Should init error when  movies is null`() = runTest {
        // GIVEN
        clearMocks(stateObserver)
        val expectedFirstState = initialState.copy(
            isLoading = true, moviesFailure = false,
            getMoviesResultItems = null
        )
        val expectedSecondState = expectedFirstState.copy(
            isLoading = false,
            moviesFailure = true, getMoviesResultItems = null
        )
        every { getMovieUseCase.invoke() } returns flow { emit(emptyList()) }

        // WHEN
        subject.getMovies()

        // THEN
        verify {
            stateObserver.onChanged(expectedFirstState)
            stateObserver.onChanged(expectedSecondState)
        }
    }
}
