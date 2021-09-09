package com.metromart.common.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import com.metromart.common.base.hilt.HiltActivityEntryPoint

abstract class BaseActivity<VB: ViewBinding>(
    private val setupViewBinding: (LayoutInflater) -> VB
): HiltActivityEntryPoint(){

    lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = setupViewBinding(layoutInflater)
        setContentView(binding.root)

        setupObserver()
        setupView()
        loadContent()
    }

    open fun setupObserver(){}
    open fun loadContent(){}
    abstract fun setupView()
}