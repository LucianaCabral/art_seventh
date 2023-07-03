package com.lcabral.features.upcoming.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lcabral.features.upcoming.domain.model.Upcoming
import com.lcabral.features.upcoming.domain.usecase.GetUpcomingUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

internal class UpcomingViewModel(
    private val upcomingUseCase: GetUpcomingUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {
    private val _viewState: MutableLiveData<UpcomingViewState> =
        MutableLiveData<UpcomingViewState>()
    val viewState: LiveData<UpcomingViewState> = _viewState

    fun getUpcoming() {
        viewModelScope.launch {
            upcomingUseCase()
                .flowOn(dispatcher)
                .onStart { handleLoading() }
                .catch { handleError() }
                .collect(::handleTrendingsSuccess)
        }
    }


    private fun handleTrendingsSuccess(popularResults: List<Upcoming>) {
        if (popularResults.isNotEmpty()) {
            _viewState.value = UpcomingViewState(
                isLoading = false,
                upcomingFailure = false, getUpcomingResultItems = popularResults
            )
        } else {
            handleError()
        }
    }

    private fun handleError() {
        _viewState.value = UpcomingViewState(
            isLoading = false, upcomingFailure = true,
            getUpcomingResultItems = null
        )
    }

    private fun handleLoading() {
        UpcomingViewState(isLoading = true, upcomingFailure = false, getUpcomingResultItems = null)
    }
}
