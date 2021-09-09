package com.metromart.common.ext

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.Toast

fun Activity.hideSoftKeyboard() {
    currentFocus?.let {
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        with(inputMethodManager) {
            hideSoftInputFromWindow(it.windowToken, 0)
        }
    }
}

fun Activity.toastLong(message: String?) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Activity.toastShort(message: String?) {
    runOnUiThread { Toast.makeText(this, message, Toast.LENGTH_SHORT).show() }
}