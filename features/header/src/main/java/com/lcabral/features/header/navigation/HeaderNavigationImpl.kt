package com.lcabral.features.header.navigation

import androidx.fragment.app.Fragment
import com.lcabral.core.common.navigation.HeaderNavigation
import com.lcabral.features.header.presentation.HeaderFragment

internal class HeaderNavigationImpl : HeaderNavigation {
    override fun create(): Fragment = HeaderFragment.newInstance()
}
