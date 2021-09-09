package com.metromart.nothing.global

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TestViewModel @Inject constructor(): ViewModel(){

    fun testViewModel() = "test test"

}