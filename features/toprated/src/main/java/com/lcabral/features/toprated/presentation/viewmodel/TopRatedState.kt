package com.lcabral.features.toprated.presentation.viewmodel

import com.lcabral.features.toprated.domain.model.TopRated

internal data class TopRatedState(
    val isLoading: Boolean = false,
    val topRatedFailure: Boolean = false,
    val getTopRatedResultItems: List<TopRated>? = null
)
