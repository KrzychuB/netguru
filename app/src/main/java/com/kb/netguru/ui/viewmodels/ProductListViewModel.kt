package com.kb.netguru.ui.viewmodels

import android.databinding.ObservableArrayList
import android.graphics.Canvas
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import com.kb.netguru.NetguruApplication
import com.kb.netguru.Utils.SwipeUtils
import com.kb.netguru.base.viewModel.BaseViewModel
import com.kb.netguru.base.viewModel.ViewModel
import com.kb.netguru.extension.navigate
import com.kb.netguru.managers.ShoppingListManager
import com.kb.netguru.models.Product
import com.kb.netguru.repository.ShopRepository
import com.kb.netguru.ui.popup.ADD_ITEM_DIALOG
import com.kb.netguru.ui.popup.addItemDialog.AddItemDialogModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ProductListViewModel @Inject constructor(val application: NetguruApplication, private val shopRepository: ShopRepository, shoppingListManager: ShoppingListManager) : BaseViewModel() {

    var items = ObservableArrayList<ViewModel>()
    var compositeDisposable = CompositeDisposable()

    init {
        val productListDisposable = shopRepository.getProductList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe( { result -> success(result) }, {} )

        compositeDisposable.add(productListDisposable)
    }

    fun onAddButtonClicked(){
        navigate(application.navigator) {
            showAddItemDialog(
                AddItemDialogModel("Add Product"),
                { dismissDialog(ADD_ITEM_DIALOG) },
                {
                    insertProduct(it)
                    dismissDialog(ADD_ITEM_DIALOG) }
            )
        }
    }

    private fun success(result: List<Product>) {
        items.clear()
        result.forEach {
            items.add(ItemProductViewModel(it))
        }
    }

    private fun insertProduct(productName: String){
        val insertDisposable = Observable.fromCallable {
            shopRepository.addProductToShoppingList(productName)
        }.subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe {}

        compositeDisposable.add(insertDisposable)
    }

    fun dispose(){

    }

    var swipeController: ItemTouchHelper.SimpleCallback? = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
        override fun onMove(p0: RecyclerView, p1: RecyclerView.ViewHolder, p2: RecyclerView.ViewHolder): Boolean {
            return false
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, p1: Int) {
            val item = items.removeAt(viewHolder.adapterPosition)
            notifyChange()
            if (item is ItemProductViewModel){
                val deleteDisposable = Observable.fromCallable {
                    shopRepository.deleteProduct(item.product)
                }.subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.io())
                    .subscribe {}

                compositeDisposable.add(deleteDisposable)
            }
        }

        override fun onChildDraw(canvas: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {
            if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
                SwipeUtils.rightSwipe(canvas, viewHolder, dX, application)
                super.onChildDraw(canvas, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
            }
        }
    }
}

