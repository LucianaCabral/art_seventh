package com.lcabral.trends.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lcabral.trends.domain.model.Trending
import com.lcabral.trends.domain.usecase.GetTrendingUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

internal class TrendingViewModel(
    private val trendingUseCase: GetTrendingUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) : ViewModel() {

    private val _viewState : MutableLiveData<ViewState> = MutableLiveData<ViewState>()
    val viewState: LiveData<ViewState> = _viewState


     fun getTrendings() {
        viewModelScope.launch {
            trendingUseCase.invoke()
                .flowOn(dispatcher)
                .onStart { handleLoading() }
                .catch { handleError() }
                .collect(::handleTrendingsSuccess)
        }
    }


    private fun handleTrendingsSuccess(trendingResults: List<Trending>) {
        if (trendingResults.isNotEmpty()) {
            _viewState.value = ViewState(isLoading = false,
                trendingsFailure = false, getTrendingsResultItems = trendingResults)
        } else {
            handleError()
        }
    }

    private fun handleError() {
         _viewState.value = ViewState(isLoading = false, trendingsFailure = true,
             getTrendingsResultItems = null) }

    private fun handleLoading() {
        ViewState(isLoading = true, trendingsFailure = false,  getTrendingsResultItems = null)
    }

}

