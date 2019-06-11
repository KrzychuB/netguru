package com.kb.netguru.di

import android.app.Application
import android.arch.persistence.room.Room
import com.kb.netguru.db.DataBase
import com.kb.netguru.db.ProductDao
import com.kb.netguru.db.ShoppingListsDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule
{
    @Singleton
    @Provides
    fun provideDatabase(app: Application): DataBase
    {
        return Room.databaseBuilder(app.applicationContext, DataBase::class.java, "ProductDatabase.db").fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideShoppingListsDao(db: DataBase): ShoppingListsDao
    {
        return db.shoppingListsDao()
    }

    @Singleton
    @Provides
    fun provideProductDao(db: DataBase): ProductDao
    {
        return db.productDao()
    }
}