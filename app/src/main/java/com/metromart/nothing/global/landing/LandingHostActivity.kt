package com.metromart.nothing.global.landing

import android.content.Context
import android.content.Intent
import com.metromart.common.base.BaseActivity
import com.metromart.nothing.databinding.ActivityLandingBinding

class LandingHostActivity : BaseActivity<ActivityLandingBinding>(ActivityLandingBinding::inflate) {

    companion object{
        fun getIntent(context: Context): Intent {
            return Intent(context, LandingHostActivity::class.java)
        }
    }

    override fun setupView() {

    }
}