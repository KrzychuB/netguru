package com.kb.netguru.ui.di

import com.kb.netguru.ui.activities.MainActivity
import com.kb.netguru.ui.viewmodels.MainActivityViewModel
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule
{
    @Provides
    fun provideMainActivity() = MainActivity()

    @Provides
    fun provideViewModel() = MainActivityViewModel()
}