package com.metromart.nothing.global.login

sealed class LoginUiState {
    object ShowLoader: LoginUiState()
    object HideLoader: LoginUiState()
    object NavigateToSignUp: LoginUiState()
    class Login(val userLoggedIn: Boolean): LoginUiState()
    class Error(val error: Throwable): LoginUiState()
}