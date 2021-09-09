package com.metromart.nothing.global.onboarding

import androidx.lifecycle.viewModelScope
import com.metromart.common.Constant.PAGE_INITIAL
import com.metromart.common.Constant.PAGE_STEP_4_POSITION
import com.metromart.common.base.BaseViewModel
import com.metromart.data.features.auth.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val authRepository: AuthRepository
): BaseViewModel() {

    private val _uiState = MutableStateFlow<OnboardingState>(OnboardingState.LoadPage)
    val uiState: StateFlow<OnboardingState> = _uiState

    private var currentPage = PAGE_INITIAL

    fun onBoardUser(){
        viewModelScope.launch(CoroutineExceptionHandler { _, error ->
            _uiState.value = OnboardingState.Error(error)
        }){
            val onboarded = authRepository.saveUserOnboarded()
            _uiState.value = OnboardingState.Onboarded(onboarded)
        }
    }

    fun loadPage() {
        viewModelScope.launch {
            _uiState.value = OnboardingState.SelectInitialPage(currentPage)
        }
    }

    fun onPageSelected(pagePosition: Int) {
        if (pagePosition == currentPage) return
        viewModelScope.launch {
            when (pagePosition) {
                PAGE_STEP_4_POSITION -> {
                    _uiState.value = OnboardingState.ShowGetStarted
                }
                else -> {
                    _uiState.value = OnboardingState.UpdatePageIndicator(
                        currentPage,
                        pagePosition
                    )
                }
            }

            currentPage = pagePosition
        }
    }

}