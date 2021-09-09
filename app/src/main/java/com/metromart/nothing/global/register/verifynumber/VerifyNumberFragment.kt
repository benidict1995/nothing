package com.metromart.nothing.global.register.verifynumber

import androidx.navigation.fragment.navArgs
import com.metromart.common.base.BaseFragment
import com.metromart.nothing.databinding.FragmentLandingBinding
import com.metromart.nothing.databinding.FragmentVerifyNumberBinding
import com.metromart.nothing.global.landing.LandingHostActivity

class VerifyNumberFragment : BaseFragment<FragmentVerifyNumberBinding>(
    FragmentVerifyNumberBinding::inflate
){

    private val args by navArgs<VerifyNumberFragmentArgs>()

    override fun setupView() {
        binding.tvSomething.text = args.something

        binding.btnDone.setOnClickListener {
            requireActivity().startActivity(
                LandingHostActivity.getIntent(requireContext())
            )
            requireActivity().finish()
        }
    }
}