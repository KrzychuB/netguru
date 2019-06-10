package com.kb.netguru.ui.di

import com.kb.netguru.ui.viewmodels.MainActivityViewModel
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule
{
    @Provides
    fun provideViewModel() = MainActivityViewModel()
}