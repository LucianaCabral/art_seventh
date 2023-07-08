package com.lcabral.artseventh

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.lcabral.artseventh.databinding.ActivityMainBinding
import com.lcabral.core.common.navigation.DashboardNavigation
import org.koin.android.ext.android.inject

private const val MAIN_ACTIVITY = "Main Activity"

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var binding: ActivityMainBinding
    private val dashboardNavigation: DashboardNavigation by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = Color.BLACK

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                replace(R.id.container_main, dashboardNavigation.create(), MAIN_ACTIVITY)
            }
        }
    }
}

