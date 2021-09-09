package com.metromart.nothing.global.splash

import com.metromart.domain.features.auth.User

sealed class SplashUiState {
    object ShowLoader: SplashUiState()
    object HideLoader: SplashUiState()
    class UserList(val userList: List<User>): SplashUiState()
    class NavigateIsOnboarded(val isOnboarded: Boolean): SplashUiState()
    class NavigateDecision(val isUserLoggedIn: Boolean): SplashUiState()
    class Error(val error: Throwable): SplashUiState()

}