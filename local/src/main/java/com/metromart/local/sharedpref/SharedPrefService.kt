package com.metromart.local.sharedpref

import android.content.SharedPreferences
import javax.inject.Inject

class SharedPrefService @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {
    fun write(key: String?, value: String?) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun write(key: String?, value: Boolean){
        sharedPreferences.edit().putBoolean(key, value).apply()
    }

    fun readString(key: String?): String? = sharedPreferences.getString(key, "")

    fun readBool(key: String): Boolean = sharedPreferences.getBoolean(key, false)
}