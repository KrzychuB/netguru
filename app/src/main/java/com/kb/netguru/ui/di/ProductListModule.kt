package com.kb.netguru.ui.di

import com.kb.netguru.NetguruApplication
import com.kb.netguru.managers.ShoppingListManager
import com.kb.netguru.repository.ShopRepository
import com.kb.netguru.ui.viewmodels.ProductListViewModel
import dagger.Module
import dagger.Provides

@Module
class ProductListModule
{
    @Provides
    fun provideViewModel(application: NetguruApplication, shopRepository: ShopRepository, shoppingListManager: ShoppingListManager) = ProductListViewModel(application, shopRepository, shoppingListManager)
}