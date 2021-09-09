package com.metromart.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.metromart.common.base.hilt.HiltFragmentEntryPoint

abstract class BaseFragment<VB: ViewBinding>(
    private val setupViewBinding: (LayoutInflater) -> VB
): HiltFragmentEntryPoint(){

    lateinit var binding: VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = setupViewBinding(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
        setupView()
        loadContent()
    }

    @Suppress("UNCHECKED_CAST")
    fun getBaseActivity() : BaseActivity<Nothing> = activity as BaseActivity<Nothing>

    open fun setupObserver(){}
    open fun loadContent(){}
    abstract fun setupView()

}