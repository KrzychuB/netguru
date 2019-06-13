package com.kb.netguru.ui.viewmodels

import android.databinding.ObservableArrayList
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

    }
}