package com.lcabral.features.upcoming.navigation

import androidx.fragment.app.Fragment
import com.lcabral.core.common.navigation.UpcomingNavigation
import com.lcabral.features.upcoming.presentation.UpComingFragment

internal class UpcomingNavigationImpl: UpcomingNavigation {
    override fun navigateToUpcoming(): Fragment {
        return UpComingFragment.newInstance()
    }
}
