package com.metromart.nothing.global.login

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.metromart.common.base.BaseFragment
import com.metromart.common.ext.navigate
import com.metromart.common.ext.toastLong
import com.metromart.nothing.databinding.FragmentLoginBinding
import com.metromart.nothing.global.landing.LandingHostActivity
import kotlinx.coroutines.flow.collect

class LoginFragment : BaseFragment<FragmentLoginBinding>(
    FragmentLoginBinding::inflate
) {

    private val viewModel: LoginViewModel by viewModels()

    override fun setupView() {
        binding.btnLogin.setOnClickListener {
            viewModel.loginUser()
        }

        binding.btnSignUp.setOnClickListener {
            navigate(LoginFragmentDirections
                .actionLoginToUserDetailsForm())
        }
    }

    override fun setupObserver() {
        super.setupObserver()
        lifecycleScope.launchWhenStarted {
            viewModel.uiState.collect { state ->
                when(state){
                    LoginUiState.ShowLoader -> {

                    }
                    LoginUiState.HideLoader -> {

                    }
                    is LoginUiState.Login -> {
                        navigateToLandingScreen()
                    }
                    is LoginUiState.Error -> {
                        requireActivity().toastLong(state.error.message)
                    }
                }
            }
        }
    }

    private fun navigateToLandingScreen(){
        startActivity(LandingHostActivity.getIntent(requireContext()))
            .run {
            requireActivity().finish()
        }
    }
}