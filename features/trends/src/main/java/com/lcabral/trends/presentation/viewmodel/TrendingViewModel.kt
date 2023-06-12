package com.lcabral.trends.presentation.viewmodel

import android.util.Log
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

    private val _viewState = MutableLiveData<ViewTrendingState>()
    val viewState: MutableLiveData<ViewTrendingState> = _viewState

    init {
        getTrendings()
    }

    private fun getTrendings() {
        viewModelScope.launch {
            trendingUseCase.invoke()
                .flowOn(dispatcher)
                .onStart { handleLoading() }
                .catch { handleError() }
                .collect(::handleTrendingsSuccess)
            Log.d("<L>", "getTrendings:${::handleTrendingsSuccess} ")
        }
    }

    private fun handleTrendingsSuccess(trendingResults: List<Trending>) {
        ViewTrendingState(
            isLoadingVisible = false,
            isErrorVisible = false,
            getTrendingsResultItems = trendingResults
        )
    }

    private fun handleLoading() {
        ViewTrendingState(
            isLoadingVisible = true,
            isErrorVisible = false,
            getTrendingsResultItems = null
        )
    }

    private fun handleError() {
        ViewTrendingState(
            isLoadingVisible = false,
            isErrorVisible = true,
            getTrendingsResultItems = null
        )
    }
}