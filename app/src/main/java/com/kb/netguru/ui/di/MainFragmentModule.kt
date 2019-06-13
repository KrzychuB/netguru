package com.kb.netguru.ui.di

import com.kb.netguru.NetguruApplication
import com.kb.netguru.repository.ShopRepository
import com.kb.netguru.ui.viewmodels.MainFragmentViewModel
import dagger.Module
import dagger.Provides

@Module
class MainFragmentModule
{
    @Provides
    fun provideViewModel(application: NetguruApplication, shopRepository: ShopRepository) = MainFragmentViewModel(application, shopRepository)
}