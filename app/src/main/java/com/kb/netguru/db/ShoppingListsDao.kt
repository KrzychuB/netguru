package com.kb.netguru.db

import android.arch.persistence.room.*
import com.kb.netguru.models.ShoppingList
import io.reactivex.Flowable

@Dao
interface ShoppingListsDao{
    @Query("SELECT * FROM shoppingList WHERE isArchived = :isArchived")
    fun getShoppingList(isArchived: Boolean) : Flowable<List<ShoppingList>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShoppingList(shoppingList: ShoppingList)

    @Delete
    fun deleteUser(shoppingList: ShoppingList)

    @Query("UPDATE shoppingList SET isArchived = :isArchived WHERE id = :shoppingListId")
    fun updateShoppingList(isArchived: Boolean, shoppingListId: Int): Int
}