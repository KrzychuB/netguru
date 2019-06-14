package com.kb.netguru.db

import android.arch.persistence.room.*
import com.kb.netguru.models.ShoppingList
import io.reactivex.Flowable

@Dao
interface ShoppingListsDao{
    @Query("SELECT * FROM shoppingList")
    fun getShoppingList() : Flowable<List<ShoppingList>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShoppingList(shoppingList: ShoppingList)

    @Delete
    fun deleteUser(shoppingList: ShoppingList)
}