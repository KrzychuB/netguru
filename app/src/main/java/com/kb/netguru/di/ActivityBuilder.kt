package com.kb.netguru.di

import com.kb.netguru.ui.activities.MainActivity
import com.kb.netguru.ui.di.MainActivityModule
import com.kb.netguru.ui.di.MainFragmentModule
import com.kb.netguru.ui.fragments.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder
{
    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [(MainFragmentModule::class)])
    abstract fun bindMainFragment(): MainFragment
}