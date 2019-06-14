package com.kb.netguru.repository

import com.kb.netguru.db.ProductDao
import com.kb.netguru.db.ShoppingListsDao
import com.kb.netguru.managers.ShoppingListManager
import com.kb.netguru.models.Product
import com.kb.netguru.models.ShoppingList
import io.reactivex.Flowable
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ShopRepository @Inject constructor(private val shoppingListsDao: ShoppingListsDao, private  val productDao: ProductDao, val shoppingListManager: ShoppingListManager) {
    fun addShopingList(shoppingListName: String) {
        val shoppingList = ShoppingList(0, shoppingListName, Date(), false)
        shoppingListsDao.insertShoppingList(shoppingList)
    }

    fun getShoppingList(isArchived: Boolean): Flowable<List<ShoppingList>> {
         return shoppingListsDao.getShoppingList(isArchived)
    }

    fun addProductToShoppingList(productName: String){
        val product = Product(0, shoppingListManager.shoppingListId!!, productName)
        productDao.insertProduct(product)
    }

    fun getProductList(): Flowable<List<Product>> {
        return productDao.getProducts(shoppingListManager.shoppingListId!!)
    }

    fun deleteProduct(product: Product) {
        productDao.deleteProduct(product)
    }

    fun archiveShoppingList(shoppingListId: Int){
        shoppingListsDao.updateShoppingList(true, shoppingListId)
    }
}