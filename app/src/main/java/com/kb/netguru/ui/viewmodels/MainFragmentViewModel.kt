package com.kb.netguru.ui.viewmodels

import android.databinding.ObservableArrayList
import android.support.v4.app.DialogFragment
import com.kb.netguru.base.viewModel.BaseViewModel
import com.kb.netguru.base.viewModel.ViewModel
import javax.inject.Inject

class MainFragmentViewModel @Inject constructor() : BaseViewModel()
{
    var items = ObservableArrayList<ViewModel>()

    init {
        items.add(ItemShoppingListViewModel())
    }

    fun onAddButtonClicked(){
        val dialogFragment = DialogFragment()
        dialogFragment.view
    }
}