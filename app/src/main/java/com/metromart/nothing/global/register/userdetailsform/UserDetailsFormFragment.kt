package com.metromart.nothing.global.register.userdetailsform

import com.metromart.common.base.BaseFragment
import com.metromart.common.ext.navigate
import com.metromart.nothing.databinding.FragmentUserDetailsFormBinding

class UserDetailsFormFragment : BaseFragment<FragmentUserDetailsFormBinding>(
    FragmentUserDetailsFormBinding::inflate
) {
    override fun setupView() {
        binding.btnNext.setOnClickListener {
            navigate(
                UserDetailsFormFragmentDirections
                    .actionUserDetailsFormToVerifyNumber(
                        binding.etSomething.text.toString()
                    )
            )
        }
    }
}