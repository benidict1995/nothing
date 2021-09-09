package com.metromart.nothing.global.splash

import android.util.Log
import androidx.activity.viewModels
import kotlinx.coroutines.flow.collect
import androidx.lifecycle.lifecycleScope
import com.metromart.common.base.BaseActivity
import com.metromart.common.ext.toast
import com.metromart.nothing.databinding.ActivitySplashBinding
import com.metromart.nothing.global.landing.LandingHostActivity
import com.metromart.nothing.global.login.LoginHostActivity
import com.metromart.nothing.global.onboarding.OnboardingActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class SplashActivity : BaseActivity<ActivitySplashBinding>(
    ActivitySplashBinding::inflate
) {
    private val viewModel: SplashViewModel by viewModels()

    override fun loadContent() {
        super.loadContent()
        viewModel.checkFirstTimeUser()
    }

    override fun setupView() {
    }

    override fun setupObserver() {
        super.setupObserver()
        lifecycleScope.launchWhenStarted {
            viewModel.uiState.collect { state ->
                when (state) {
                    SplashUiState.ShowLoader -> {
                    }
                    SplashUiState.HideLoader -> {
                    }
                    is SplashUiState.UserList -> {
//                        Log.d("makerChecker", "userList:${state.userList}")
                    }
                    is SplashUiState.NavigateDecision -> {
                        Log.d("makerChecker", "NavigateDecision-isUserLoggedIn:${state.isUserLoggedIn}")
                        navigateState(state.isUserLoggedIn)
                    }
                    is SplashUiState.NavigateIsOnboarded -> {
                        Log.d("makerChecker", "NavigateIsOnboarded-isOnboarded:${state.isOnboarded}")
                        navigateToOnboarding(state.isOnboarded)
                    }
                    is SplashUiState.Error -> {
                        toast(state.error.localizedMessage)
                    }
                }
            }
        }
    }

    private fun navigateToOnboarding(isUserOnboarded: Boolean) {
        if (!isUserOnboarded) {
            startActivity(OnboardingActivity.getIntent(this))
            finish()
        } else {
            viewModel.checkIfUserLoggedIn()
        }
    }

    private fun navigateState(isUserLoggedIn: Boolean) {
        startActivity(
            if (isUserLoggedIn)
                LandingHostActivity.getIntent(this)
            else
                LoginHostActivity.getIntent(this)
        )
        finish()
    }
}