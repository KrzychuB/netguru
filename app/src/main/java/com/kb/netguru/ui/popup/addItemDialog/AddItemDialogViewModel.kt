package com.kb.netguru.ui.popup.addItemDialog

import com.kb.netguru.base.viewModel.BaseViewModel

class AddItemDialogViewModel(
        val confirmDialogModel: AddItemDialogModel,
        private val buttonNegativeListener: () -> Unit,
        private val buttonPositiveListener: () -> Unit
): BaseViewModel()
{
    fun onButtonNegativeClicked(){
        buttonNegativeListener()
    }

    fun onButtonPositiveClicked(){
        buttonPositiveListener()
    }
}