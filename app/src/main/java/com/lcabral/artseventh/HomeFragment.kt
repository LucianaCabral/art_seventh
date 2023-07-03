package com.lcabral.artseventh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.lcabral.artseventh.databinding.FragmentHomeBinding
import com.lcabral.core.common.navigation.PopularNavigation
import com.lcabral.core.common.navigation.TrendsNavigation
import org.koin.android.ext.android.inject

private const val HOME_FRAGMENT = "Home Fragment"

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val trendingNavigation: TrendsNavigation by inject()
    private val popularNavigation: PopularNavigation by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            parentFragmentManager.commit {
                replace(R.id.home_container,trendingNavigation.navigateToTrend(), HOME_FRAGMENT)
                replace(R.id.home_container, popularNavigation.navigateToPopular(), HOME_FRAGMENT)
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
        fun newInstance() : HomeFragment = HomeFragment()
    }
}
