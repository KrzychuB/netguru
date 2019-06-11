package com.kb.netguru.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.kb.netguru.models.Product
import com.kb.netguru.models.ShoppingList

@Database(entities = [ShoppingList::class, Product::class], version = 1)
abstract class DataBase: RoomDatabase()
{
    abstract fun productDao(): ProductDao
    abstract fun shoppingListsDao(): ShoppingListsDao
}