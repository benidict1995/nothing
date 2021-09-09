package com.metromart.nothing.global.splash

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.metromart.common.base.BaseViewModel
import com.metromart.data.features.auth.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : BaseViewModel() {

    private val _uiState = MutableStateFlow<SplashUiState>(SplashUiState.ShowLoader)
    val uiState: StateFlow<SplashUiState> = _uiState

    fun loadUserList(){
        viewModelScope.launch(CoroutineExceptionHandler{ _, error ->
            _uiState.value = SplashUiState.Error(error)
        }) {
            val userList = authRepository.loadUserList()
            _uiState.value = SplashUiState.UserList(userList)
            _uiState.value = SplashUiState.NavigateDecision(true)
        }
    }

    fun checkFirstTimeUser(){
        viewModelScope.launch(CoroutineExceptionHandler{_, error ->
            _uiState.value = SplashUiState.Error(error)
        }){
            val isUserOnboarded = authRepository.loadIsUserOnboarded()
            Log.d("makerChecker", "checkFirstTimeUser-isUserOnboarded:${isUserOnboarded}")
            _uiState.value = SplashUiState.NavigateIsOnboarded(isUserOnboarded)
        }
    }

    fun checkIfUserLoggedIn(){
        viewModelScope.launch(CoroutineExceptionHandler{_, error ->
            _uiState.value = SplashUiState.Error(error)
        }){
            val isUserLoggedIn = authRepository.loadIsUserLoggedIn()
            Log.d("makerChecker", "checkIfUserLoggedIn-isOnboarded:${isUserLoggedIn}")
            _uiState.value = SplashUiState.NavigateIsOnboarded(isUserLoggedIn)
        }
    }
}