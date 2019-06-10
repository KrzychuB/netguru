package com.kb.netguru.ui.fragments

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kb.netguru.BR
import com.kb.netguru.R
import com.kb.netguru.base.fragment.BaseFragment
import com.kb.netguru.base.fragment.BaseFragmentWithVM
import com.kb.netguru.base.viewModel.BaseViewModel
import com.kb.netguru.ui.viewmodels.MainFragmentViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class MainFragment : BaseFragmentWithVM()
{
    @Inject
    lateinit var mainFragmentViewModel: MainFragmentViewModel

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun provideLayoutResID(): Int {
        return R.layout.fragment_main
    }

    override fun provideViewModel(savedInstanceState: Bundle?): BaseViewModel {
        return mainFragmentViewModel
    }
}