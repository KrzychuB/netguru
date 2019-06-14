package com.kb.netguru.ui.viewmodels

import android.databinding.ObservableArrayList
import com.kb.netguru.NetguruApplication
import com.kb.netguru.base.viewModel.BaseViewModel
import com.kb.netguru.base.viewModel.ViewModel
import com.kb.netguru.extension.navigate
import com.kb.netguru.managers.ShoppingListManager
import com.kb.netguru.models.ShoppingList
import com.kb.netguru.repository.ShopRepository
import com.kb.netguru.ui.popup.ADD_ITEM_DIALOG
import com.kb.netguru.ui.popup.addItemDialog.AddItemDialogModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import io.reactivex.disposables.CompositeDisposable



class MainFragmentViewModel @Inject constructor(val application: NetguruApplication, private val shopRepository: ShopRepository, private val shoppingListManager: ShoppingListManager) : BaseViewModel() {

    var items = ObservableArrayList<ViewModel>()
    var compositeDisposable = CompositeDisposable()


    init {
        val shoppingListDisposable = shopRepository.getShoppingList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe( {result -> success(result) }, {} )

        compositeDisposable.add(shoppingListDisposable)
    }

    private fun success(result: List<ShoppingList>) {
        items.clear()
        result.forEach {
            items.add(ItemShoppingListViewModel(it, ::onItemClicked))
        }
    }

    private fun onItemClicked(shoppingList: ShoppingList){
        shoppingListManager.shoppingListId = shoppingList.id

        navigate(application.navigator) {
            goToProductList()
        }
    }

    fun onAddButtonClicked() {
        navigate(application.navigator) {
            showAddItemDialog(
                    AddItemDialogModel("Add Shopping List"),
                    { dismissDialog(ADD_ITEM_DIALOG) },
                    {
                        insertShoppingList(it)
                        dismissDialog(ADD_ITEM_DIALOG) }
            )
        }
    }

    private fun insertShoppingList(s: String){
        val insertDisposable = Observable.fromCallable {
            shopRepository.addShopingList(s)
        }.subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe {}

        compositeDisposable.add(insertDisposable)
    }

    fun dispose(){
        compositeDisposable.dispose()
    }
}