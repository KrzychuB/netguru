package com.kb.netguru.base.fragment

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kb.netguru.BR
import com.kb.netguru.base.viewModel.BaseViewModel
import dagger.android.support.AndroidSupportInjection

abstract class BaseFragmentWithVM : BaseFragment() {

    protected lateinit var viewModel: BaseViewModel
    protected var binding: ViewDataBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    private fun setAndBindContentView(viewModel: BaseViewModel, inflater: LayoutInflater, container: ViewGroup?, @LayoutRes layoutResID: Int): View {
        binding = DataBindingUtil.inflate(inflater, layoutResID, container, false)
        binding!!.setVariable(BR.vm, viewModel)
        binding!!.executePendingBindings()
        return binding!!.root
    }

    final override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (!this::viewModel.isInitialized) {
            viewModel = provideViewModel(savedInstanceState)
        }
        val layoutResID = provideLayoutResID()
        val view = setAndBindContentView(viewModel, inflater, container, layoutResID)
        return view
    }

    abstract fun provideViewModel(savedInstanceState: Bundle?): BaseViewModel

    @LayoutRes
    abstract fun provideLayoutResID(): Int
}
