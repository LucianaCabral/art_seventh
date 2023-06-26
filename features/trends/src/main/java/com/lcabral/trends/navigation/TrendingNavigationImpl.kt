package com.lcabral.trends.navigation

import androidx.fragment.app.Fragment
import com.lcabral.core.common.navigation.TrendsNavigation
import com.lcabral.trends.presentation.TrendingFragment

internal class TrendingNavigationImpl: TrendsNavigation {
    override fun navigateToTrend(): Fragment = TrendingFragment.newInstance()
}