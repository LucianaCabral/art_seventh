package com.lcabral.features.dashboard.extensions

import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.lcabral.features.dashboard.presentation.DashboardFragment

internal fun DashboardFragment.includeChild(containerId: Int, fragment: Fragment) {
    childFragmentManager.commit { replace(containerId, fragment, fragment::class.java.simpleName) }
}
