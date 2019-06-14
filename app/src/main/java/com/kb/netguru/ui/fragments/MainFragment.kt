package com.kb.netguru.ui.fragments

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import com.kb.netguru.R
import com.kb.netguru.base.fragment.BaseFragmentWithVM
import com.kb.netguru.base.viewModel.BaseViewModel
import com.kb.netguru.ui.viewmodels.MainFragmentViewModel
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)
    }

    override fun onDestroy() {
        super.onDestroy()
        mainFragmentViewModel.dispose()
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.main_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
}