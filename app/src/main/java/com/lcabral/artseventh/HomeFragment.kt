package com.lcabral.artseventh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lcabral.artseventh.databinding.FragmentHomeBinding
import com.lcabral.artseventh.extensions.includeChild
import com.lcabral.core.common.navigation.HeaderNavigation
import com.lcabral.core.common.navigation.PopularNavigation
import com.lcabral.core.common.navigation.TopRatedNavigation
import com.lcabral.core.common.navigation.TrendsNavigation
import com.lcabral.core.common.navigation.UpcomingNavigation
import org.koin.android.ext.android.inject

class
HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
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
                includeChild(homeContainer.id,headerNavigation.create())
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    companion object {
        fun newInstance(): HomeFragment = HomeFragment()
    }
}
