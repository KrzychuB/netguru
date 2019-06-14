package com.kb.netguru.ui.viewmodels

import android.databinding.ObservableField
import com.kb.netguru.base.viewModel.BaseViewModel
import com.kb.netguru.extension.navigate
import com.kb.netguru.helper.Navigator
import com.kb.netguru.models.ShoppingList

class ItemShoppingListViewModel(private val shoppingList: ShoppingList, val onItemClick: (shoppingList: ShoppingList) -> Unit): BaseViewModel() {

    val shoppingListName = ObservableField("Name")

    init {
        shoppingListName.set(shoppingList.shoppingListsName)
    }

    fun onItemClicked(){
        onItemClick(shoppingList)
    }
}