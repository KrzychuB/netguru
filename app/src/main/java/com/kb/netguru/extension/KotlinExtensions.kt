package com.kb.netguru.extension

import android.support.v4.app.DialogFragment
import com.kb.netguru.base.activity.BaseActivity
import com.kb.netguru.base.fragment.BaseFragment
import com.kb.netguru.base.viewModel.BaseViewModel
import com.kb.netguru.helper.BaseNavigator
import com.kb.netguru.helper.Navigator

inline fun BaseFragment.navigate(navigator: Navigator, command: Navigator.() -> Unit) {
    command.invoke(navigator)
}

inline fun BaseViewModel.navigate(navigator: Navigator, command: Navigator.() -> Unit) {
    command.invoke(navigator)
}

inline fun BaseActivity.navigate(navigator: Navigator, command: Navigator.() -> Unit) {
    command.invoke(navigator)
}

inline fun <reified T : DialogFragment> BaseNavigator.getDialogByTag(tag: String, dialogListener: (T) -> Unit) {
    val fragmentByTag = getFragmentManager()?.findFragmentByTag(tag)
    if (fragmentByTag is T) {
        dialogListener(fragmentByTag)
    }
}