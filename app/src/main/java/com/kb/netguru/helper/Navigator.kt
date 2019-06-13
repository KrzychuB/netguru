package com.kb.netguru.helper

import android.support.annotation.LayoutRes
import android.support.v4.app.DialogFragment
import com.kb.netguru.base.activity.BaseActivity
import com.kb.netguru.base.viewModel.BaseViewModel
import com.kb.netguru.extension.getDialogByTag
import com.kb.netguru.ui.fragments.MainFragment
import com.kb.netguru.ui.popup.BaseDialog

@Suppress("UNUSED")
class Navigator(activity: BaseActivity) : BaseNavigator(activity) {

    fun goToForgetPassword() {
        val fragment = MainFragment.newInstance()
        replaceFragment(fragment, true)
    }

    private fun showDialog(viewModel: BaseViewModel, @LayoutRes layoutResID: Int, tag: String, sizePercent: Float = 0.85f, hideCurrent: Boolean = true, cancelable: Boolean = true) {
        if (hideCurrent) {
            dismissDialog(tag)
        }

        getForegroundActivity()?.also {
            BaseDialog().apply {
                this.isCancelable = cancelable

                if (!isAdded) {
                    prepareDialog(viewModel, layoutResID)
                    dialogSize = sizePercent
                    show(it.supportFragmentManager, tag)
                }
            }
        }
    }

    fun dismissDialog(tag: String) {
        getDialogByTag<DialogFragment>(tag) {
            it.dismiss()
        }
    }
}