package com.kb.netguru.helper

import android.support.annotation.LayoutRes
import android.support.v4.app.DialogFragment
import com.kb.netguru.R
import com.kb.netguru.base.activity.BaseActivity
import com.kb.netguru.base.viewModel.BaseViewModel
import com.kb.netguru.extension.getDialogByTag
import com.kb.netguru.ui.fragments.MainFragment
import com.kb.netguru.ui.fragments.ProductListFragment
import com.kb.netguru.ui.popup.ADD_ITEM_DIALOG
import com.kb.netguru.ui.popup.BaseDialog
import com.kb.netguru.ui.popup.addItemDialog.AddItemDialogModel
import com.kb.netguru.ui.popup.addItemDialog.AddItemDialogViewModel

@Suppress("UNUSED")
class Navigator(activity: BaseActivity) : BaseNavigator(activity) {

    fun goToMainFragment() {
        val fragment = MainFragment.newInstance()
        replaceFragment(fragment, false)
    }

    fun goToProductList() {
        val fragment = ProductListFragment.newInstance()
        replaceFragment(fragment, true)
    }

    fun showAddItemDialog(addItemDialogModel: AddItemDialogModel, buttonNegativeListener: () -> Unit, buttonPositiveListener: (shoppingListName: String) -> Unit) {
        val viewModel = AddItemDialogViewModel(addItemDialogModel, buttonNegativeListener, buttonPositiveListener)
        showDialog(viewModel, R.layout.dialog_add_item, ADD_ITEM_DIALOG)
    }

    private fun showDialog(viewModel: BaseViewModel, @LayoutRes layoutResID: Int, tag: String, sizePercent: Float = 0.85f, hideCurrent: Boolean = true, cancelable: Boolean = false) {
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