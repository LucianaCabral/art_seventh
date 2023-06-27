package com.lcabral.trends.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.lcabral.trends.domain.usecase.GetTrendingUseCase
import com.lcabral.trends.presentation.stubs.TrendingTestData.getTrendings
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
internal class TrendingViewModelTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    val dispatcherRule = MainDispatcherRule()

    @get:Rule
    val testRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    private var initialState = ViewState()
    private var getTrendingUseCase: GetTrendingUseCase = mockk(relaxed = true)
    private val stateObserver: Observer<ViewState> = mockk(relaxed = true)
    private lateinit var subject: TrendingViewModel
    private val trendingsResult = getTrendings()

    @Before
    fun setup() {
        subject = TrendingViewModel(
            trendingUseCase = getTrendingUseCase,
            dispatcher = dispatcherRule.testDispatcher
        )
        subject.viewState.observeForever(stateObserver)
    }

    @After
    fun tearDown() {
        subject.viewState.removeObserver(stateObserver)
        clearAllMocks()
    }

    @Test
    fun `init Should init fetch trendings movies`() = runTest {
        // GIVEN
        clearMocks(stateObserver)
        val expectedFirstState = initialState.copy(
            isLoading = true, trendingsFailure = false,
            getTrendingsResultItems = null
        )
        val expectedSecondState = expectedFirstState.copy(
            isLoading = false, trendingsFailure = false, getTrendingsResultItems = trendingsResult
        )
        every { getTrendingUseCase.invoke() } returns flow { emit(trendingsResult) }

        // WHEN
        subject.getTrendings()

        // THEN
        stateObserver.onChanged(expectedFirstState)
        stateObserver.onChanged(expectedSecondState)
        verify { getTrendingUseCase.invoke() }
    }

    @Test
    fun `init Should init error when trendings movies is null`() = runTest {
        // GIVEN
        clearMocks(stateObserver)
        val expectedFirstState = initialState.copy(
            isLoading = true, trendingsFailure = false,
            getTrendingsResultItems = null
        )
        val expectedSecondState = expectedFirstState.copy(isLoading = false,
            trendingsFailure = true, getTrendingsResultItems = null)
        every { getTrendingUseCase.invoke() } returns flow { emit(emptyList()) }

        // WHEN
        subject.getTrendings()

        // THEN
        stateObserver.onChanged(expectedFirstState)
        stateObserver.onChanged(expectedSecondState)
        verify { getTrendingUseCase.invoke() }
    }
}