package com.kb.netguru.ui.viewmodels

import android.databinding.ObservableArrayList
import com.kb.netguru.NetguruApplication
import com.kb.netguru.base.viewModel.BaseViewModel
import com.kb.netguru.base.viewModel.ViewModel
import com.kb.netguru.extension.navigate
import com.kb.netguru.repository.ShopRepository
import com.kb.netguru.ui.popup.ADD_ITEM_DIALOG
import com.kb.netguru.ui.popup.addItemDialog.AddItemDialogModel
import javax.inject.Inject

class MainFragmentViewModel @Inject constructor(val application: NetguruApplication, private val shopRepository: ShopRepository) : BaseViewModel() {

    var items = ObservableArrayList<ViewModel>()

    init {
        items.add(ItemShoppingListViewModel())
    }

    fun onAddButtonClicked() {
        navigate(application.navigator) {
            showAddItemDialog(
                    AddItemDialogModel("Add Shopping List"),
                    { dismissDialog(ADD_ITEM_DIALOG) },
                    { shopRepository::addShopingList; dismissDialog(ADD_ITEM_DIALOG) }
            )
        }
    }
}