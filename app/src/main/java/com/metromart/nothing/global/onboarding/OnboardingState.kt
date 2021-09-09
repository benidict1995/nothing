package com.metromart.nothing.global.onboarding

sealed class OnboardingState {
    object LoadPage : OnboardingState()

    object ShowGetStarted : OnboardingState()

    class Onboarded(val isOnboarded: Boolean): OnboardingState()

    class Error(val error: Throwable): OnboardingState()

    data class UpdatePageIndicator(
        val previousPage: Int,
        val currentPage: Int
    ): OnboardingState()

    data class SelectInitialPage(
        val currentPage: Int
    ): OnboardingState()
}