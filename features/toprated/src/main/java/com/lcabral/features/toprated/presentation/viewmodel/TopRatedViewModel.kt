package com.lcabral.features.toprated.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lcabral.features.toprated.domain.model.TopRated
import com.lcabral.features.toprated.domain.usecase.GetTopRatedUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

internal class TopRatedViewModel(
    private val topRatedUseCase: GetTopRatedUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val _viewState: MutableLiveData<TopRatedState> = MutableLiveData<TopRatedState>()
    val viewState: LiveData<TopRatedState> = _viewState

    fun getTopRated() {
        viewModelScope.launch {
            topRatedUseCase.invoke()
                .flowOn(dispatcher)
                .onStart { handleLoading() }
                .catch { handleError() }
                .collect(::handleTopRatedSuccess)
        }
    }


    private fun handleTopRatedSuccess(topRatedResults: List<TopRated>) {
        if (topRatedResults.isNotEmpty()) {
            _viewState.value = TopRatedState(
                isLoading = false,
                topRatedFailure = false, getTopRatedResultItems = topRatedResults
            )
        } else {
            handleError()
        }
    }

    private fun handleError() {
        _viewState.value = TopRatedState(
            isLoading = false, topRatedFailure = true, getTopRatedResultItems = null
        )
    }

    private fun handleLoading() {
        TopRatedState(isLoading = true, topRatedFailure = false, getTopRatedResultItems = null)
    }
}
