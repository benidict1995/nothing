package com.metromart.nothing.global.login

import android.content.Context
import android.content.Intent
import com.metromart.common.base.BaseActivity
import com.metromart.nothing.databinding.ActivityLoginBinding
import com.metromart.nothing.global.landing.LandingHostActivity

class LoginHostActivity : BaseActivity<
        ActivityLoginBinding>(ActivityLoginBinding::inflate) {

    companion object{
        fun getIntent(context: Context): Intent {
            return Intent(context, LoginHostActivity::class.java)
        }
    }

    override fun setupView() {

    }
}