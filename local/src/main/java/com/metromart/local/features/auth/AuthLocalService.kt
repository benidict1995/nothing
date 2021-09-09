package com.metromart.local.features.auth

import com.metromart.local.sharedpref.Key.KEY_ONBOARDING
import com.metromart.local.sharedpref.Key.KEY_USER_LOGGED_IN
import com.metromart.local.sharedpref.SharedPrefService
import javax.inject.Inject

class AuthLocalService @Inject constructor(
    private val sharedPrefService: SharedPrefService
){

    fun saveUserOnboarded(): Boolean{
        sharedPrefService.write(KEY_ONBOARDING, true)
        return true
    }

    fun loadIsUserOnboarded(): Boolean{
        return sharedPrefService.readBool(KEY_ONBOARDING)
    }

    fun saveUserLoggedIn(): Boolean{
        sharedPrefService.write(KEY_USER_LOGGED_IN, true)
        return true
    }

    fun loadIsUserLoggedIn(): Boolean{
        return sharedPrefService.readBool(KEY_USER_LOGGED_IN)
    }

}