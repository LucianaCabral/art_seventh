package com.lcabral.features.dashboard.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lcabral.core.common.navigation.HeaderNavigation
import com.lcabral.core.common.navigation.PopularNavigation
import com.lcabral.core.common.navigation.TopRatedNavigation
import com.lcabral.core.common.navigation.TrendsNavigation
import com.lcabral.core.common.navigation.UpcomingNavigation
import com.lcabral.features.dashboard.R
import com.lcabral.features.dashboard.databinding.FragmentDashboardBinding
import com.lcabral.features.dashboard.extensions.includeChild
import org.koin.android.ext.android.inject

internal class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!
    private val trendingNavigation: TrendsNavigation by inject()
    private val popularNavigation: PopularNavigation by inject()
    private val upcomingNavigation: UpcomingNavigation by inject()
    private val topRatedNavigation: TopRatedNavigation by inject()
    private val headerNavigation: HeaderNavigation by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            with(binding) {
                includeChild(trendingContainer.id, trendingNavigation.navigateToTrend())
                includeChild(popularContainer.id, popularNavigation.navigateToPopular())
                includeChild(upcomingContainer.id, upcomingNavigation.navigateToUpcoming())
                includeChild(topRatedContainer.id, topRatedNavigation.create())
                includeChild(homeContainer.id, headerNavigation.create())
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    companion object {
        fun newInstance(): DashboardFragment = DashboardFragment()
    }
}
