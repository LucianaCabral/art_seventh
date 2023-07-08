package com.lcabral.features.dashboard.navigation

import androidx.fragment.app.Fragment
import com.lcabral.core.common.navigation.DashboardNavigation
import com.lcabral.features.dashboard.presentation.DashboardFragment

internal class DashBoardNavigationImpl : DashboardNavigation {
    override fun create(): Fragment = DashboardFragment.newInstance()
}
