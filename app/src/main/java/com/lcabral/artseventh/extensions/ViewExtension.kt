package com.lcabral.artseventh.extensions

import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.lcabral.artseventh.HomeFragment

internal fun HomeFragment.includeChild(containerId: Int, fragment: Fragment) {
    childFragmentManager.commit { replace(containerId, fragment, fragment::class.java.simpleName) }
}
