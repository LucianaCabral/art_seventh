package com.lcabral.features.popular.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lcabral.features.popular.domain.model.Popular
import com.lcabral.features.popular.domain.usecase.GetPopularUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

internal class PopularViewModel(
    private val popularUseCase: GetPopularUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val _viewState: MutableLiveData<PopularViewState> = MutableLiveData<PopularViewState>()
    val viewState:LiveData<PopularViewState> = _viewState

    fun getPopular() {
        viewModelScope.launch {
            popularUseCase.invoke()
                .flowOn(dispatcher)
                .onStart { handleLoading() }
                .catch { handleError() }
                .collect(::handleTrendingsSuccess)
        }
    }


    private fun handleTrendingsSuccess(popularResults: List<Popular>) {
        if (popularResults.isNotEmpty()) {
            _viewState.value = PopularViewState(
                isLoading = false,
                popularFailure = false, getPopularResultItems = popularResults
            )
        } else {
            handleError()
        }
    }

    private fun handleError() {
        _viewState.value = PopularViewState(
            isLoading = false, popularFailure = true,
            getPopularResultItems = null
        )
    }

    private fun handleLoading() {
        PopularViewState(isLoading = true, popularFailure = false, getPopularResultItems = null)
    }
}
