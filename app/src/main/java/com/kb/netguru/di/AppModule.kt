package com.kb.netguru.di

import android.app.Application
import android.arch.persistence.room.Room
import com.kb.netguru.NetguruApplication
import com.kb.netguru.db.DataBase
import com.kb.netguru.db.ProductDao
import com.kb.netguru.db.ShoppingListsDao
import com.kb.netguru.managers.ShoppingListManager
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

    @Singleton
    @Provides
    fun provideApplication(app: Application): NetguruApplication
    {
        return app as NetguruApplication
    }

    @Provides
    @Singleton
    fun provideShoppingListManager(): ShoppingListManager
    {
        return ShoppingListManager()
    }
}