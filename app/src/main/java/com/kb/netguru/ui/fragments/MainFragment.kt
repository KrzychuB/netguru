package com.kb.netguru.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kb.netguru.R
import com.kb.netguru.ui.viewmodels.MainFragmentViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class MainFragment : Fragment()
{
    @Inject
    lateinit var mainFragmentViewModel: MainFragmentViewModel

    companion object
    {
        fun newInstance() = MainFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }
}