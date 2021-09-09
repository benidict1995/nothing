package com.metromart.nothing.global.landing

import com.metromart.common.base.BaseFragment
import com.metromart.common.ext.navigate
import com.metromart.nothing.databinding.FragmentLandingBinding

class LandingFragment : BaseFragment<FragmentLandingBinding>(
    FragmentLandingBinding::inflate
) {
    override fun setupView() {
        binding.btnMetrofood.setOnClickListener {
            navigate(
                LandingFragmentDirections
                    .navigateLandingMetroFood()
            )
        }

        binding.btnMetromart.setOnClickListener {
            navigate(
                LandingFragmentDirections
                    .navigateLandingMetroMart()
            )
        }
    }
}