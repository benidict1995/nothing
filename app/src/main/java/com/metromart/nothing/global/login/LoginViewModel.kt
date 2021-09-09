package com.metromart.nothing.global.login

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
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository
): BaseViewModel() {
    private val _uiState = MutableStateFlow<LoginUiState>(LoginUiState.ShowLoader)
    val uiState: StateFlow<LoginUiState> = _uiState

    fun loginUser(){
        viewModelScope.launch(CoroutineExceptionHandler { _, error ->
            _uiState.value = LoginUiState.Error(error)
        }){
            val userLoggedIn = authRepository.saveUserLoggedIn()
            _uiState.value = LoginUiState.Login(userLoggedIn)
        }
    }
}