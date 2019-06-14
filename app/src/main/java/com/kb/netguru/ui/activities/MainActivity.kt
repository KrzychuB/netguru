package com.kb.netguru.ui.activities

import android.os.Bundle
import com.kb.netguru.base.activity.BaseActivity
import com.kb.netguru.extension.navigate

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        val navigator = application.navigator
        navigate(navigator){ goToMainFragment() }
    }
}
