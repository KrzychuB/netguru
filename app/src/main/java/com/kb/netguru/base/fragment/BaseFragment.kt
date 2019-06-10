package com.kb.netguru.base.fragment

import android.support.v4.app.Fragment

abstract class BaseFragment : Fragment() {

    open fun tagFragment(): String {
        return this::class.java.simpleName
    }

    open fun onBackPressed(): Boolean {
        return false
    }
}