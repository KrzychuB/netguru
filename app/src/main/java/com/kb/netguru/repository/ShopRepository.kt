package com.kb.netguru.repository

import com.kb.netguru.db.ShoppingListsDao
import com.kb.netguru.models.ShoppingList
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ShopRepository @Inject constructor (private val shoppingListsDao: ShoppingListsDao){
    fun addShopingList(shoppingListName: String){
        val shoppingList = ShoppingList(0, shoppingListName, Date())
        shoppingListsDao.insertShoppingList(shoppingList)
    }
}