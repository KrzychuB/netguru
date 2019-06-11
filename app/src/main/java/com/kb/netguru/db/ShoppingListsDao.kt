package com.kb.netguru.db

import android.arch.persistence.room.*
import com.kb.netguru.models.ShoppingList

@Dao
interface ShoppingListsDao{
//    @Query("SELECT * FROM shoppingList")
//    fun getShoppingList()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShoppingList(transformer: ShoppingList)

    @Delete
    fun deleteUser(transformer: ShoppingList)
}