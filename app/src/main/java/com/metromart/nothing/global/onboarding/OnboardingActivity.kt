package com.metromart.nothing.global.onboarding

import android.animation.AnimatorSet
import android.animation.ValueAnimator
import android.content.Context
import android.content.Intent
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.metromart.common.Constant.PAGE_STEP_1_POSITION
import com.metromart.common.Constant.PAGE_STEP_2_POSITION
import com.metromart.common.Constant.PAGE_STEP_3_POSITION
import com.metromart.common.Constant.PAGE_STEP_4_POSITION
import com.metromart.common.base.BaseActivity
import com.metromart.common.ext.gone
import com.metromart.common.ext.invisible
import com.metromart.common.ext.toastLong
import com.metromart.common.ext.visible
import com.metromart.nothing.R
import com.metromart.nothing.databinding.ActivityOnboardingBinding
import com.metromart.nothing.global.login.LoginHostActivity
import com.metromart.nothing.global.onboarding.adapter.OnboardingAdapter
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect

@ExperimentalCoroutinesApi
class OnboardingActivity : BaseActivity<ActivityOnboardingBinding>(ActivityOnboardingBinding::inflate){

    private val viewModel: OnboardingViewModel by viewModels()

    private var indicatorDefaultWidth: Int = 0
    private var indicatorSelectedWidth: Int = 0

    companion object{
        fun getIntent(context: Context): Intent {
            return Intent(context, OnboardingActivity::class.java)
        }
    }

    private val pageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            viewModel.onPageSelected(position)
        }
    }

    override fun setupView() {
        initPagerIndicator()
        initGetStarted()
        setupViewPager()
    }

    override fun loadContent() {
        super.loadContent()
        viewModel.loadPage()
    }

    private fun initGetStarted() = binding.btnGetStarted.setOnClickListener {
        viewModel.onBoardUser()
    }

    override fun setupObserver() {
        super.setupObserver()
        lifecycleScope.launchWhenStarted {
            viewModel.uiState.collect { state ->
                when (state) {
                    OnboardingState.LoadPage -> {

                    }
                    OnboardingState.ShowGetStarted -> {
                        binding.btnGetStarted.visible()
                        binding.tvDescription.invisible()
                        binding.indicators.invisible()
                    }
                    is OnboardingState.Onboarded -> {
                        navigateToLogin()
                    }
                    is OnboardingState.UpdatePageIndicator -> {
                        binding.btnGetStarted.gone()
                        binding.tvDescription.visible()
                        binding.indicators.visible()
                        updatePageIndicator(
                            state.previousPage,
                            state.currentPage
                        )
                    }
                    is OnboardingState.SelectInitialPage -> {
                        selectInitialPage(state.currentPage)
                    }
                    is OnboardingState.Error -> {
                         toastLong(state.error.message)
                    }
                }
            }
        }
    }

    private fun navigateToLogin(){
        startActivity(LoginHostActivity.getIntent(this))
        finish()
    }

    private fun initPagerIndicator() {
        indicatorDefaultWidth = resources.getDimensionPixelSize(R.dimen.dp_8)
        indicatorSelectedWidth = resources.getDimensionPixelSize(R.dimen.dp_16)
    }

    private fun setupViewPager() {
        binding.viewPager
            .apply {
                adapter = OnboardingAdapter()
                offscreenPageLimit = 2
                registerOnPageChangeCallback(pageChangeCallback)
            }
    }

    private fun selectInitialPage(currentPage: Int) {
        val initialIndicator = when (currentPage) {
            PAGE_STEP_1_POSITION -> binding.indicator1
            PAGE_STEP_2_POSITION -> binding.indicator2
            PAGE_STEP_3_POSITION -> binding.indicator3
            PAGE_STEP_4_POSITION -> binding.indicator4
            else -> throw  IllegalArgumentException("Invalid currentPage")
        }
        initialIndicator.isSelected = true
        initialIndicator
            .layoutParams
            .width = resources.getDimensionPixelSize(R.dimen.dp_16)
        initialIndicator.requestLayout()
    }

    private fun updatePageIndicator(previousPage: Int, currentPage: Int) {
        val currentIndicator = when (currentPage) {
            PAGE_STEP_1_POSITION -> binding.indicator1
            PAGE_STEP_2_POSITION -> binding.indicator2
            PAGE_STEP_3_POSITION -> binding.indicator3
            PAGE_STEP_4_POSITION -> binding.indicator4
            else -> throw  IllegalArgumentException("Invalid currentPage")
        }

        val previousIndicator = when (previousPage) {
            PAGE_STEP_1_POSITION -> binding.indicator1
            PAGE_STEP_2_POSITION -> binding.indicator2
            PAGE_STEP_3_POSITION -> binding.indicator3
            PAGE_STEP_4_POSITION -> binding.indicator4
            else -> throw  IllegalArgumentException("Invalid previousPage")
        }

        currentIndicator.isSelected = true
        previousIndicator.isSelected = false

        val current = ValueAnimator.ofInt(indicatorDefaultWidth, indicatorSelectedWidth)
            .apply {
                addUpdateListener { valueAnimator ->
                    val newWidth = valueAnimator.animatedValue as Int
                    currentIndicator.layoutParams.width = newWidth
                    currentIndicator.requestLayout()
                }
            }

        val previous = ValueAnimator.ofInt(indicatorSelectedWidth, indicatorDefaultWidth)
            .apply {
                addUpdateListener { valueAnimator ->
                    val newWidth = valueAnimator.animatedValue as Int
                    previousIndicator.layoutParams.width = newWidth
                    previousIndicator.requestLayout()
                }
            }

        AnimatorSet()
            .apply {
                playTogether(
                    current,
                    previous
                )
                duration = 300
                interpolator = android.view.animation.AccelerateDecelerateInterpolator()
                start()
            }
    }

    override fun onDestroy() {
        binding
            .viewPager
            .unregisterOnPageChangeCallback(
                pageChangeCallback
            )
        super.onDestroy()
    }
}