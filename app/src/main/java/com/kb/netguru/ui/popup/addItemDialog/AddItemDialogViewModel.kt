package com.kb.netguru.ui.popup.addItemDialog

import android.databinding.ObservableField
import com.kb.netguru.base.viewModel.BaseViewModel

class AddItemDialogViewModel(
        val confirmDialogModel: AddItemDialogModel,
        private val buttonNegativeListener: () -> Unit,
        private val buttonPositiveListener: (shoppingListName: String) -> Unit
): BaseViewModel()
{
    val shoppingListName = ObservableField("")

    fun onButtonNegativeClicked(){
        buttonNegativeListener()
    }

    fun onButtonPositiveClicked(){
        val listName = shoppingListName.get() ?: ""
        buttonPositiveListener(listName)
    }
}