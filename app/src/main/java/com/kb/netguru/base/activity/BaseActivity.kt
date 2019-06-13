package com.kb.netguru.base.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.kb.netguru.NetguruApplication
import com.kb.netguru.R
import com.kb.netguru.base.fragment.BaseFragment
import com.kb.netguru.helper.Navigator
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity(), HasSupportFragmentInjector
{
    @Inject
    internal lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    internal lateinit var application: NetguruApplication

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigator = Navigator(this)
        application.navigator = navigator
    }

    override fun onBackPressed() {
        val fragmentList = supportFragmentManager.fragments
        val lastFragmentInBackStack = fragmentList.lastOrNull()
        if (lastFragmentInBackStack is BaseFragment) {
            val backPressEventConsumed = lastFragmentInBackStack.onBackPressed()
            if (backPressEventConsumed) {
                return
            }
        }

        super.onBackPressed()
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment>
    {
        return fragmentInjector
    }
}